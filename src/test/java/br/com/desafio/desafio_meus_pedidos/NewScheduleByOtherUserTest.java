package br.com.desafio.desafio_meus_pedidos;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.desafio.desafio_meus_pedidos.NewSchedulePage;
import br.com.desafio.desafio_meus_pedidos.SchedulePage;

public class NewScheduleByOtherUserTest extends BaseTest {
	private static final String EMPTY_LIST_TEXT = "Não possui atividade.";
	private static final String OTHER_USER = "Faust2";
	private static final String SUCCESS_TEXT_SAVE = "Ligação cadastrada com sucesso!";
	private SchedulePage schedulePage;
	private NewSchedulePage newSchedulePage;

	@Test
	public void newScheduleByOtherUserTest() {
		setupPages();
		schedulePage.goToSchedulePage();
		schedulePage.newScheduleButtonClick();
		createSchedulingWithOtherUser();
		findAndDeleteSchedule();
	}

	private void findAndDeleteSchedule() {
		schedulePage.filterByUser();
		schedulePage.alterScheduleClick();
		newSchedulePage.deleteScheduling();
		Assert.assertEquals(schedulePage.getTextToListScheduleEmpty(), EMPTY_LIST_TEXT);
	}

	private void createSchedulingWithOtherUser() {
		Assert.assertEquals(newSchedulePage.newScheduleIsVisible(), true);
		newSchedulePage.typeCallOptionClick();
		newSchedulePage.changeUser(OTHER_USER);
		newSchedulePage.clickSave();
		Assert.assertEquals(schedulePage.toasterSuccessIsVisible(), SUCCESS_TEXT_SAVE);
	}

	private void setupPages() {
		schedulePage = new SchedulePage(driver);
		newSchedulePage = new NewSchedulePage(driver);
	}
}
