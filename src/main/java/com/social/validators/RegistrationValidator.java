package com.social.validators;

import com.social.entities.User;
import com.social.requests.UserRegisterRequest;
import com.social.services.UserService;
import javax.inject.Inject;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Katarzyna on 2017-03-26.
 */
@Component
public class RegistrationValidator implements Validator {

    private final UserService userService;


    @Inject
    public RegistrationValidator( final UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserRegisterRequest user = (UserRegisterRequest) o;
        Locale locale = new Locale("");
        if (userService.emailExist(user.getEmail())) {
            errors.rejectValue("email", "Email.exist", "Istnieje już konto powiązane z takim e-mailem.");
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username", "Wybierz login zawierający od 6 do 32 znkaków.");
        }


        if (userService.getByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username", "Ten login jest juz zajęty.");

        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password", "Hasło musi być dłuższe niż 6 znaków.");
        }

        System.out.println(user.getPasswordConfirm());
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm", "Hasła nie zgadzają się.");
        }
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        matcher = pattern.matcher(user.getEmail());
        if (!(matcher.matches())) {
            errors.rejectValue("email", "BadForm.userForm.email", "Niepoprawna forma adresu e-mail.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
        if (user.getFirstName().length() < 3 || user.getFirstName().length() > 40) {
            errors.rejectValue("firstName", "Size.userForm.firstName", "Wpisz poprawne imię (3-40 znaków).");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
        if (user.getLastName().length() < 3 || user.getLastName().length() > 40) {
            errors.rejectValue("lastName", "Size.userForm.lastName", "Wpisz poprawne nazwisko (3-40 znaków).");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "NotEmpty");
        if (user.getCity().length() < 3 || user.getCity().length() > 40) {
            errors.rejectValue("city", "Size.userForm.city", "Wpisz poprawne miasto (3-40 znaków).");
        }

    }

}

