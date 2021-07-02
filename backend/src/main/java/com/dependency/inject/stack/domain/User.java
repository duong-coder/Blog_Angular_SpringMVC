//package com.dependency.inject.stack.domain;
//
//import static com.dependency.inject.stack.common.UserConstants.NONE_GENDER;
//
//import java.io.Serializable;
//import java.time.Instant;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//
//import lombok.Data;
//
///**
// * The type User.
// */
//@Data
//@Entity
//@Table(name = "hdht_user")
//public class User implements Serializable {
//
//    /**
//     * 
//     */
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "first_name", nullable = false)
//    private String firstName;
//
//    @Column(name = "last_name", nullable = false)
//    private String lastName;
//
//    @Column(name = "phone", nullable = false, unique = true)
//    private String phone;
//
//    @Column(name = "gender")
//    private Integer gender = NONE_GENDER;
//
//    @Column(name = "image_url", length = 256)
//    private String imageUrl;
//
//    @Column(name = "email", unique = true)
//    private String email;
//
//    @Column(name = "birthday")
//    private Instant birthday;
//
//    @Column(name = "address")
//    private String address;
//
//    @Column(name = "password")
//    private String password;
//
//    @Column(name = "activated")
//    private Integer activated;
//
//    @Column(name = "create_date")
//    private Instant createdDate;
//
//    @Column(name = "last_update_date")
//    private Instant lastUpdatedDate;
//
//    @ManyToMany
//    @JoinTable(
//            name = "hdht_user_authority",
//            joinColumns = {@JoinColumn(name = "user_id")},
//            inverseJoinColumns = {@JoinColumn(name = "authority_id")}
//    )
//    private List<Authority> authorities;
//
////    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
////    private List<MedicalHistory> medicalHistories;
//
////    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.REMOVE)
////    private List<Appointment> appointments;
//
//}
