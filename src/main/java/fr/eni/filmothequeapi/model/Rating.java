package fr.eni.filmothequeapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "comment", length = 500)
    String comment;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Rating(long id, String comment, Member member) {
        this.id = id;
        this.comment = comment;
        this.member = member;
    }

    public Rating(String comment, Member member) {
        this.comment = comment;
        this.member = member;
    }

    public Rating() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", member=" + member +
                '}';
    }
}
