package itmo.is.dto.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChapterDto(
        @JsonProperty("id")
        Long id,

        @JsonProperty("name")
        String name,

        @JsonProperty("parent_legion")
        String parentLegion,

        @JsonProperty("marines_count")
        long marinesCount,

        @JsonProperty("admin_edit_allowed")
        boolean adminEditAllowed
) {
}
