package ar.gururoot.app;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("ar.gururoot.app");

        noClasses()
            .that()
            .resideInAnyPackage("ar.gururoot.app.service..")
            .or()
            .resideInAnyPackage("ar.gururoot.app.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..ar.gururoot.app.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
