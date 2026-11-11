# No imprime secretos. Requiere AWS CLI v2 y perfil estudio previamente configurado.
[CmdletBinding()]
param([string]$Profile = 'estudio', [string]$Region = 'eu-west-1')
$ErrorActionPreference = 'Stop'
$clientLab = Read-Host 'ClientId de Outputs'
$userLab = Read-Host 'Usuario ficticio'
$secretLab = Read-Host 'Contraseña' -AsSecureString
$credentialLab = [pscredential]::new($userLab, $secretLab)
$tempLab = Join-Path ([IO.Path]::GetTempPath()) ('aws-study-' + [guid]::NewGuid().ToString())
$fileLab = Join-Path $tempLab 'request.json'
try {
    New-Item -ItemType Directory -Path $tempLab | Out-Null
    $aclLab = New-Object System.Security.AccessControl.DirectorySecurity
    $identityLab = [System.Security.Principal.WindowsIdentity]::GetCurrent().Name
    $ruleLab = New-Object System.Security.AccessControl.FileSystemAccessRule($identityLab,'FullControl','ContainerInherit,ObjectInherit','None','Allow')
    $aclLab.SetAccessRuleProtection($true,$false)
    $aclLab.AddAccessRule($ruleLab)
    Set-Acl -LiteralPath $tempLab -AclObject $aclLab
    $payloadLab = @{
        AuthFlow = 'USER_PASSWORD_AUTH'
        ClientId = $clientLab
        AuthParameters = @{ USERNAME = $userLab; PASSWORD = $credentialLab.GetNetworkCredential().Password }
    } | ConvertTo-Json -Compress
    [IO.File]::WriteAllText($fileLab, $payloadLab, [Text.UTF8Encoding]::new($false))
    $responseLab = & aws cognito-idp initiate-auth --cli-input-json "file://$fileLab" --region $Region --profile $Profile --output json
    if ($LASTEXITCODE -ne 0) { throw 'Autenticacion fallida; revisa perfil, usuario y challenge.' }
    $parsedLab = ($responseLab -join [Environment]::NewLine) | ConvertFrom-Json
    if ($parsedLab.ChallengeName) { throw 'Cognito requiere un challenge. Resuelvelo antes de solicitar token.' }
    return $parsedLab
} finally {
    $payloadLab = $null
    $credentialLab = $null
    if (Test-Path -LiteralPath $fileLab) { Remove-Item -LiteralPath $fileLab -Force }
    if (Test-Path -LiteralPath $tempLab) { Remove-Item -LiteralPath $tempLab -Force }
}
