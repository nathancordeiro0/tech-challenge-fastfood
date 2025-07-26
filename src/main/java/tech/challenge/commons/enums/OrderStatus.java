package tech.challenge.commons.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    RECEIVED(3),
    IN_PROGRESS(2),
    READY(1),
    FINISHED(0);

    private final int order;

    OrderStatus(int order) {
        this.order = order;
    }
}
