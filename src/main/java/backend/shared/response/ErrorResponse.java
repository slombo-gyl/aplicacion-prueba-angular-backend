package backend.shared.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(
        LocalDateTime timestamp,
        String title,
        int status,
        String detail,
        String instance,
        Map<String, List<String>> errors
) {
    public ErrorResponse(String title, int status, String detail, String instance, Map<String, List<String>> errors) {
        this(LocalDateTime.now(), title, status, detail, instance, errors);
    }

    public ErrorResponse(String title, int status, String detail, String instance) {
        this(LocalDateTime.now(), title, status, detail, instance, null);
    }
}