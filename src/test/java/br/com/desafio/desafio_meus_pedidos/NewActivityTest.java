package br.com.desafio.desafio_meus_pedidos;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.desafio.desafio_meus_pedidos.NewActivityPage;
import br.com.desafio.desafio_meus_pedidos.SchedulePage;

public class NewActivityTest extends BaseTest {
	private static final String EMPTY_LIST_TEXT = "Não possui atividade.";
	private static final String SUCCESS_TEXT_SAVE = "Visita cadastrada com sucesso!";
	private SchedulePage schedulePage;
	private NewActivityPage newActivityPage;

	@Test
	public void newActivityTest() {
		setupPages();
		schedulePage.goToSchedulePage();
		registerActivityAndValidateMessageSuccess();
		schedulePage.filterByCompletedActivity();
		deleteAndValidateActivity();
	}

	private void deleteAndValidateActivity() {
		schedulePage.alterScheduleClick();
		newActivityPage.deleteActivity();
		Assert.assertEquals(schedulePage.schedulePageIsVisible(), true);
		Assert.assertEquals(schedulePage.getTextToListScheduleEmpty(), EMPTY_LIST_TEXT);
	}

	private void setupPages() {
		schedulePage = new SchedulePage(driver);
		newActivityPage = new NewActivityPage(driver);
	}

	private void registerActivityAndValidateMessageSuccess() {
		schedulePage.newActivityButtonClick();
		Assert.assertEquals(newActivityPage.newActivityIsVisible(), true);
		newActivityPage.descriptionSendKeys("Atividade teste");
		newActivityPage.clickSave();
		Assert.assertEquals(schedulePage.toasterSuccessIsVisible(), SUCCESS_TEXT_SAVE);

	}

}
