module br.org.rfdouro.app01 {
    requires javafx.controls;
    requires javafx.fxml;
    /*requires microstream.storage.embedded.configuration;
    requires microstream.storage.embedded;
    requires microstream.storage;
    requires microstream.persistence.binary;
    requires microstream.persistence;
    requires microstream.configuration;
    requires microstream.base;*/
 requires java.base;

    opens br.org.rfdouro.app01 to javafx.fxml;
    exports br.org.rfdouro.app01;
}
