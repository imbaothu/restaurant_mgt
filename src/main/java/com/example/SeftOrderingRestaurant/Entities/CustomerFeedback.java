package com.example.SeftOrderingRestaurant.Entities;

import com.example.SeftOrderingRestaurant.Enums.FeedbackStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "CustomerFeedback")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Feedback_ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Customer_ID", nullable = true)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "Order_ID", nullable = true)
    private Orders order_id;

    @Column(name = "Rating", nullable = false)
    private Integer rating;

    @Column(name = "Comment", columnDefinition = "TEXT")
    private String comment;

    @Column(name = "FeedbackDate", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime feedbackDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false, columnDefinition = "ENUM('New', 'Reviewed', 'Resolved')")
    private FeedbackStatus status;

    @PrePersist
    protected void onCreate() {
        this.feedbackDate = LocalDateTime.now();
    }
}