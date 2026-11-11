param([ValidateRange(0,4)][int]$Dominio = 0, [ValidateRange(1,24)][int]$Cantidad = 6)
$ErrorActionPreference = 'Stop'
$questionsLab = Get-Content -LiteralPath (Join-Path $PSScriptRoot 'banco.json') -Raw -Encoding UTF8 | ConvertFrom-Json
if ($Dominio -ne 0) { $questionsLab = @($questionsLab | Where-Object { $_.domain -eq $Dominio }) }
$questionsLab = @($questionsLab | Get-Random -Count ([Math]::Min($Cantidad, @($questionsLab).Count)))
$correctLab = 0
foreach ($itemLab in $questionsLab) {
    Write-Host "`nDominio $($itemLab.domain): $($itemLab.question)"
    for ($iLab = 0; $iLab -lt $itemLab.options.Count; $iLab++) { Write-Host "$($iLab + 1). $($itemLab.options[$iLab])" }
    do { $choiceLab = Read-Host 'Elige 1, 2 o 3' } while ($choiceLab -notmatch '^[123]$')
    if (([int]$choiceLab - 1) -eq $itemLab.answer) { $correctLab++; Write-Host 'Correcto' -ForegroundColor Green }
    else { Write-Host "Respuesta correcta: $($itemLab.answer + 1)" -ForegroundColor Yellow }
    Write-Host $itemLab.explanation
}
Write-Host "`nResultado: $correctLab / $($questionsLab.Count). Practica didactica; no predice el resultado del examen."
