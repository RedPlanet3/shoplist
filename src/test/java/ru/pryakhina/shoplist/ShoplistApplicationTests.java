package ru.pryakhina.shoplist;

import jakarta.persistence.PersistenceContext;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.pryakhina.shoplist.dao.ItemDAO;
import ru.pryakhina.shoplist.dao.RoleDAO;

//@SpringBootTest
//class ShoplistApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.pryakhina.shoplist.entity.Item;
import ru.pryakhina.shoplist.entity.Role;

import java.util.List;


//@DataJpaTest
//@SpringBootTest

//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Testcontainers


@SpringBootTest
public class ShoplistApplicationTests {
//
//	@PersistenceContext
//	private TestEntityManager entityManager;

	@Autowired
	private RoleDAO roleDAO;

	@Autowired
	private ItemDAO itemDAO;


	@Test
	public void should_find_no_roles_if_repository_is_empty() {
		List<Role> roles = roleDAO.getAllRoles();
		assertThat(roles).isEmpty();
	}
	@Test
	public void saveOneRole() {
		Role role = new Role("Admin");
		roleDAO.saveRole(role);
		assertThat(roleDAO.getRole(role.getId()))
				.hasFieldOrPropertyWithValue("name", "Admin");
	}

	@Test
	public void saveOneRoleAndItems() {
		Role role = new Role("Admin");
		role.addItemToRole(new Item("Bread", 233, role));
		role.addItemToRole(new Item("Milk", 45, role));
		assertThat(role.getItems()).hasSize(2);
	}

	@Test
	public void saveOneRoleAndItemsToBase() {
		Role role = new Role("Admin");
		role.addItemToRole(new Item("Bread", 233, role));
		role.addItemToRole(new Item("Milk", 45, role));
		roleDAO.saveRole(role);
		assertThat(role.getItems()).hasSize(2);
	}

	@Test
	public void addManyRoles() {
			Role tut1 = new Role("Tut#1");
			roleDAO.saveRole(tut1);

			Role tut2 = new Role("Tut#2");
			roleDAO.saveRole(tut2);

			Role tut3 = new Role("Tut#3");
			roleDAO.saveRole(tut3);

			List<Role> roles = roleDAO.getAllRoles();

		assertThat(roles).hasSize(3);
	}

	@Test
	public void findRole() {
		Role tut1 = new Role("Tut#1");
		roleDAO.saveRole(tut1);

		Role tut2 = new Role("Tut#2");
		roleDAO.saveRole(tut2);

		Role tut3 = new Role("Tut#3");
		roleDAO.saveRole(tut3);

		Role role = roleDAO.getRole(2);
		assertThat(role.getName()).isEqualTo(tut2.getName());
	}

	@Test
	public void addManyRolesAndDel() {
		Role tut1 = new Role("Tut#1");
		roleDAO.saveRole(tut1);

		Role tut2 = new Role("Tut#2");
		roleDAO.saveRole(tut2);

		Role tut3 = new Role("Tut#3");
		roleDAO.saveRole(tut3);

		Role deleteRole = roleDAO.getRole(2);
		roleDAO.delRole(deleteRole);

		List<Role> roles = roleDAO.getAllRoles();
		assertThat(roles).hasSize(2);
	}

	@Test
	public void should_find_no_items_if_repository_is_empty() {
		Role tut1 = new Role("Tut#1");
		roleDAO.saveRole(tut1);
		List<Item> items = itemDAO.getRoleItems(1);
		assertThat(items).isEmpty();
	}
	@Test
	public void saveOneItem() {
		Role tut1 = new Role("Tut#1");
		roleDAO.saveRole(tut1);
		Item item = new Item("Bread", 34, tut1);
		itemDAO.saveItem(item);
		assertThat(itemDAO.getItem(item.getId()))
				.hasFieldOrPropertyWithValue("name", "Bread");
	}


	@Test
	public void addManyItems() {
		Role tut1 = new Role("Tut#1");
		roleDAO.saveRole(tut1);

		Item item1 = new Item("Bread", 34, tut1);
		Item item2 = new Item("milk", 10, tut1);
		Item item3 = new Item("eggs", 5, tut1);

		roleDAO.saveRole(tut1);


		List<Item> items = roleDAO.getRole(1).getItems();

		assertThat(items).hasSize(3);
	}

	@Test
	public void findItem() {
		Role tut1 = new Role("Tut#1");
		Item item1 = new Item("Bread", 34, tut1);
		Item item2 = new Item("milk", 10, tut1);
		Item item3 = new Item("eggs", 5, tut1);

		roleDAO.saveRole(tut1);

		Item item4 = itemDAO.getItem(1);
		assertThat(item1.getName()).isEqualTo(item4.getName());
	}

	@Test
	public void addManyItemsAndDel() {
		Role tut1 = new Role("Tut#1");
		Item item1 = new Item("Bread", 34, tut1);
		Item item2 = new Item("milk", 10, tut1);
		Item item3 = new Item("eggs", 5, tut1);

		roleDAO.saveRole(tut1);
		itemDAO.delItem(item1);

		List<Item> items = roleDAO.getRole(1).getItems();
		assertThat(items).hasSize(2);
	}
}