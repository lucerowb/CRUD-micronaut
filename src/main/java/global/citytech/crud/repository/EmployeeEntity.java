package global.citytech.crud.repository;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
@Introspected
@MappedEntity("employees")
public record EmployeeEntity(
        @Id
        @GeneratedValue(GeneratedValue.Type.AUTO)
        long id,

        @MappedProperty(value = "name")
        String name
) {
}
