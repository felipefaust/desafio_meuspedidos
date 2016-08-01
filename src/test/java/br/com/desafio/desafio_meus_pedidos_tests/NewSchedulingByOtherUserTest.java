package br.com.desafio.desafio_meus_pedidos_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.desafio.desafio_meus_pedidos_pages.NewSchedulingPage;
import br.com.desafio.desafio_meus_pedidos_pages.SchedulePage;

public class NewSchedulingByOtherUserTest extends DefaultClassTest {
	private static final String OTHER_USER = "Faust2";
	private static final String SUCCESS_TEXT_SAVE = "Ligação cadastrada com sucesso!";
	private static final String EMPTY_LIST_TEXT = "Não possui atividade.";
	private SchedulePage schedulePage;
	private NewSchedulingPage newSchedulingPage;

	@Test
	public void newSchedulingByOtherUser() {
		setupPages();
		schedulePage.goToSchedulePage();
		schedulePage.newSchedulingButtonClick();
		createSchedulingWithOtherUser();
		findAndDeleteSchedule();
	}

	private void findAndDeleteSchedule() {
		schedulePage.filterByUser();
		schedulePage.alterSchedulingClick();
		newSchedulingPage.deleteScheduling();
		Assert.assertEquals(schedulePage.schedulePageIsVisible(), true);
		Assert.assertEquals(schedulePage.getTextToListScheduleEmpty(), EMPTY_LIST_TEXT);
	}

	private void createSchedulingWithOtherUser() {
		Assert.assertEquals(newSchedulingPage.newSchedulingIsVisible(), true);
		newSchedulingPage.typeCallOptionClick();
		newSchedulingPage.changeUser(OTHER_USER);
		newSchedulingPage.clickSave();
		Assert.assertEquals(schedulePage.toasterSuccessIsVisible(), SUCCESS_TEXT_SAVE);
	}

	private void setupPages() {
		schedulePage = new SchedulePage(driver);
		newSchedulingPage = new NewSchedulingPage(driver);
	}
}
