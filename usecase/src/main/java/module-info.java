module usecase {
    exports com.kf.example.usecase;
    exports com.kf.example.usecase.ports;
    exports com.kf.example.usecase.exception;

    requires domain;
    requires org.apache.commons.lang3;
}