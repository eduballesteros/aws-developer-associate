package estudio.aws;

import java.util.UUID;

public final class TaskRules {
    private TaskRules() {}
    public static String id(String value) {
        if (value == null || value.length() > 36) throw new IllegalArgumentException("id UUID requerido");
        UUID parsed = UUID.fromString(value);
        if (!parsed.toString().equalsIgnoreCase(value)) throw new IllegalArgumentException("id UUID invalido");
        return parsed.toString();
    }
    public static String title(String value) {
        if (value == null || value.isBlank() || value.length() > 120)
            throw new IllegalArgumentException("titulo de 1 a 120 caracteres requerido");
        return value.strip();
    }
}
