package global.citytech.crud.controller.payloads;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;


@Introspected
public record EmployeePayload(
        @Nullable
        long id,
        String name
) {
}
