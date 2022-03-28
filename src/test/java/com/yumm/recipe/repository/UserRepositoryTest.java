package com.yumm.recipe.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.yumm.recipe.entities.User;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Test
    public void save_StoresUser_WhenUserIsValid() {

        final User expected = new User();
        expected.setUserName("divya");;
        expected.setPassword("123");;

        final User saved = repository.save(expected);

        final User actual = entityManager.find(User.class, saved.getUserName());

        assertThat(actual).isEqualTo(expected);
    }

}
