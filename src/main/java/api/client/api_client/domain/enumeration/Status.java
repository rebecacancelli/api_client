package api.client.api_client.domain.enumeration;


public enum Status {
    SUCESS(1),
    WARNING(2),
    ERROR(3);

    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
