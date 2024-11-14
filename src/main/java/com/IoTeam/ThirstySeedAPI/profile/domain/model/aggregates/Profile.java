package com.IoTeam.ThirstySeedAPI.profile.domain.model.aggregates;

import com.IoTeam.ThirstySeedAPI.iam.domain.model.aggregates.User;
import com.IoTeam.ThirstySeedAPI.profile.domain.model.commands.CreateProfileCommand;
import com.IoTeam.ThirstySeedAPI.profile.domain.model.valueobjects.*;
import com.IoTeam.ThirstySeedAPI.profile.domain.model.valueobjects.Location;
import com.IoTeam.ThirstySeedAPI.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Profile extends AuditableAbstractAggregateRoot<Profile> {
    @OneToOne
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User user;

    @Embedded
    private PersonName name;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "address", column = @Column(name = "email_address"))})
    EmailAddress email;

    @Embedded
    private PhoneNumber phoneNumber;

    @Embedded
    private ProfileImage profileImage;

    @Embedded
    private Location location;

    public Profile(User user, String firstName, String lastName, String email, String phoneNumber, String profileImage, String location) {
        this.user = user;
        this.name = new PersonName(firstName, lastName);
        this.email = new EmailAddress(email);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.profileImage = new ProfileImage(profileImage);
        this.location = new Location(location);
    }

    public Profile(User user, CreateProfileCommand command) {
        this(
                user,
                command.firstName(),
                command.lastName(),
                command.email(),
                command.phoneNumber(),
                command.profileImage(),
                command.location()
        );
    }

    public Profile() {
    }

    public void updateName(String firstName, String lastName) {
        this.name = new PersonName(firstName, lastName);
    }

    public void updateEmail(String email) {
        this.email = new EmailAddress(email);
    }

    public void updatePhoneNumber(String phoneNumber) {
        this.phoneNumber = new PhoneNumber(phoneNumber);
    }

    public void updateProfileImage(String profileImage) {
        this.profileImage = new ProfileImage(profileImage);
    }

    public void updateLocation(String location) {
        this.location = new Location(location);
    }

    public Long getUserId() {
        return user.getId();
    }

    public String getFullName() {
        return name.getFullName();
    }

    public String getEmailAddress() {
        return email.address();
    }

    public String getPhoneNumber() {
        return phoneNumber.number();
    }

    public String getProfileImage() {
        return profileImage.imageUrl();
    }

    public String getLocation() {
        return location.location();
    }
}
