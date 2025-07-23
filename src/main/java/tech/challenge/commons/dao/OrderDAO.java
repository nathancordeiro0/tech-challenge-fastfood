package tech.challenge.commons.dao;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import tech.challenge.commons.enums.OrderStatus;

import java.time.OffsetDateTime;
import java.util.UUID;

@With
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_order")
public class OrderDAO {
    @Id
    @UuidGenerator
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "customer_id")
    private UUID customerId;

    @Generated
    @Column(name = "number", nullable = false, unique = true, insertable = false)
    private Long orderNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @CreationTimestamp
    @Column(name = "order_date", nullable = false, updatable = false)
    private OffsetDateTime orderDate;

    @Column(name = "finished_date", updatable = false)
    private OffsetDateTime finishedDate;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;
}
