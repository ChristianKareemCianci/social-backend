package com.example.chiara.entity;

import javax.persistence.*;

@Entity
@Table(name = "profile",
        schema = "testapi_db"
)
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "profile_photo")
    private String profilePhoto;

    @Column(name = "bg_photo")
    private String bgPhoto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Profile() {

    }

    public Profile(String firstName, String lastName, String profilePhoto, String bgPhoto, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePhoto = profilePhoto;
        this.bgPhoto = bgPhoto;
        this.user = user;
    }

    public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getProfilePhoto() {
    return profilePhoto;
  }

  public void setProfilePhoto(String profilePhoto) {
    this.profilePhoto = profilePhoto;
  }

  public String getBgPhoto() {
    return bgPhoto;
  }

  public void setBgPhoto(String bgPhoto) {
    this.bgPhoto = bgPhoto;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "Profile{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", profilePhoto='" + profilePhoto + '\'' +
            ", bgPhoto='" + bgPhoto + '\'' +
            ", user=" + user +
            '}';
  }
}
