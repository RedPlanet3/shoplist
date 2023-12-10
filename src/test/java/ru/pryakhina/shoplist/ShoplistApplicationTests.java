package ru.pryakhina.shoplist;

import org.springframework.boot.test.context.SpringBootTest;
import ru.pryakhina.shoplist.dao.ItemRepository;
import ru.pryakhina.shoplist.dao.RoleRepository;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.pryakhina.shoplist.entity.Item;
import ru.pryakhina.shoplist.entity.Role;
import ru.pryakhina.shoplist.service.ShopListService;

import java.util.List;


//@DataJpaTest
//@SpringBootTest

//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Testcontainers

@SpringBootTest
public class ShoplistApplicationTests {

	@Autowired
	private ShopListService shopListService;


	@Test
	public void should_find_no_roles_if_repository_is_empty() {
		List<Role> roles = shopListService.getAllRoles();
		assertThat(roles).isEmpty();
	}
	@Test
	public void saveOneRole() {
		Role role = new Role("Admin");
		shopListService.saveRole(role);
		assertThat(shopListService.getRole(role.getId()))
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
		shopListService.saveRole(role);
		assertThat(role.getItems()).hasSize(2);
	}

	@Test
	public void addManyRoles() {
			Role tut1 = new Role("Tut#1");
		shopListService.saveRole(tut1);

			Role tut2 = new Role("Tut#2");
		shopListService.saveRole(tut2);

			Role tut3 = new Role("Tut#3");
		shopListService.saveRole(tut3);

		List<Role> roles = shopListService.getAllRoles();

		assertThat(roles).hasSize(3);
	}

	@Test
	public void findRole() {
		Role tut1 = new Role("Tut#1");
		shopListService.saveRole(tut1);

		Role tut2 = new Role("Tut#2");
		shopListService.saveRole(tut2);

		Role tut3 = new Role("Tut#3");
		shopListService.saveRole(tut3);

		Role role = shopListService.getRole(1);
		assertThat(role.getName()).isEqualTo(tut1.getName());
	}

	@Test
	public void addManyRolesAndDel() {
		Role tut1 = new Role("Tut#1");
		shopListService.saveRole(tut1);

		Role tut2 = new Role("Tut#2");
		shopListService.saveRole(tut2);

		Role tut3 = new Role("Tut#3");
		shopListService.saveRole(tut3);

		Role deleteRole = shopListService.getRole(2);
		shopListService.delRole(deleteRole);

		List<Role> roles = shopListService.getAllRoles();
		assertThat(roles).hasSize(2);
	}

	@Test
	public void should_find_no_items_if_repository_is_empty() {
		Role tut1 = new Role("Tut#1");
		shopListService.saveRole(tut1);
		List<Item> items = shopListService.getRoleItems(tut1.getId());
		assertThat(items).isEmpty();
	}
	@Test
	public void saveOneItem() {
		Role tut1 = new Role("Tut#1");
		shopListService.saveRole(tut1);
		Item item = new Item("Bread", 34, tut1);
		shopListService.saveItem(item);
		assertThat(shopListService.getItem(item.getId()))
				.hasFieldOrPropertyWithValue("name", "Bread");
	}


	@Test
	public void addManyItems() {
		Role tut1 = new Role("Tut#1");
		tut1.addItemToRole(new Item("Bread", 34, tut1));
		tut1.addItemToRole(new Item("milk", 10, tut1));
		tut1.addItemToRole(new Item("eggs", 5, tut1));
		shopListService.saveRole(tut1);
		List<Item> items = shopListService.getRoleItems(tut1.getId());
		assertThat(items).hasSize(3);
	}

	@Test
	public void findItem() {
		Role tut1 = new Role("Tut#1");

		Item item1 = new Item("Bread", 34, tut1);
		Item item2 = new Item("milk", 10, tut1);
		Item item3 = new Item("eggs", 5, tut1);
		tut1.addItemToRole(item1);
		tut1.addItemToRole(item2);
		tut1.addItemToRole(item3);

		shopListService.saveRole(tut1);

		Item item4 = shopListService.getItem(item1.getId());
		if (item4 != null)
			assertThat(item1.getName()).isEqualTo(item4.getName());
	}

	@Test
	public void addManyItemsAndDel() {
		Role tut1 = new Role("Tut#1");

		Item item1 = new Item("Bread", 34, tut1);
		Item item2 = new Item("milk", 10, tut1);
		Item item3 = new Item("eggs", 5, tut1);
		tut1.addItemToRole(item1);
		tut1.addItemToRole(item2);
		tut1.addItemToRole(item3);
		shopListService.saveRole(tut1);
		shopListService.delItem(item1);

		List<Item> items = shopListService.getRole(1).getItems();
		assertThat(items).hasSize(2);
	}
}