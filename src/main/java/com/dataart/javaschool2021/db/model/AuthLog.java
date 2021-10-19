package com.dataart.javaschool2021.db.model;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name="auth_log")
public class AuthLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="username", nullable=false)
    private User user;

    @Column(name="logged_at")
    private ZonedDateTime loggedAt;

    public AuthLog() {
    }

    public AuthLog(User user, ZonedDateTime loggedAt) {
        this.user = user;
        this.loggedAt = loggedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ZonedDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(ZonedDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AuthLog{");
        sb.append("id=").append(id);
        sb.append(", user=").append(user);
        sb.append(", loggedAt=").append(loggedAt);
        sb.append('}');
        return sb.toString();
    }
}
