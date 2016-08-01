package br.com.desafio.desafio_meus_pedidos_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.desafio.desafio_meus_pedidos_pages.NewSchedulingPage;
import br.com.desafio.desafio_meus_pedidos_pages.SchedulePage;

public class NewSchedulingTest extends DefaultClassTest {
	private static final String COSTUMER_NAME = "Supermercado do Bairro";
	private static final String EMPTY_LIST_TEXT = "Não possui atividade.";
	private static final String NOTE_TEXT = "Teste de observação!@123";
	private static final String SUCCESS_TEXT_SAVE = "Ligação cadastrada com sucesso!";
	private static final String TEXT_NOTE_CALL = "teste observacao 123";
	private SchedulePage schedulePage;
	private NewSchedulingPage newSchedulingPage;

	@Test
	public void scheduleTest() {
		setupPages();
		openAndValidateSchedule();
		createAndValidateScheduling();
		validateListScheduling();
		setDoneAndCommentCall();
		deleteAndValidateScheduling();
	}

	private void setDoneAndCommentCall() {
		schedulePage.setDoneCall();
		Assert.assertEquals(schedulePage.callIsDone(), true);
		schedulePage.commentCall(TEXT_NOTE_CALL);
		schedulePage.alterSchedulingClick();
		Assert.assertEquals(schedulePage.getCommentCall(), TEXT_NOTE_CALL);
	}

	private void deleteAndValidateScheduling() {
		newSchedulingPage.deleteScheduling();
		Assert.assertEquals(schedulePage.schedulePageIsVisible(), true);
		Assert.assertEquals(schedulePage.getTextToListScheduleEmpty(), EMPTY_LIST_TEXT);
	}

	private void validateListScheduling() {
		Assert.assertEquals(schedulePage.getTextToNoteItemListSchedule(), NOTE_TEXT);
	}

	private void createAndValidateScheduling() {
		openAndValidateScheduling();
		newSchedulingPage.typeCallOptionClick();
		setAndValidadeCostumer();
		newSchedulingPage.noteSendKeys(NOTE_TEXT);
		saveAndValidadeScheduling();
	}

	private void saveAndValidadeScheduling() {
		newSchedulingPage.clickSave();
		Assert.assertEquals(schedulePage.toasterSuccessIsVisible(), SUCCESS_TEXT_SAVE);
	}

	private void setAndValidadeCostumer() {
		newSchedulingPage.setCostumer(COSTUMER_NAME);
		Assert.assertEquals(newSchedulingPage.costumerSelectedIsVisible(), true);
	}

	private void openAndValidateScheduling() {
		schedulePage.newSchedulingButtonClick();
		Assert.assertEquals(newSchedulingPage.newSchedulingIsVisible(), true);
	}

	private void openAndValidateSchedule() {
		schedulePage.goToSchedulePage();
		Assert.assertEquals(schedulePage.schedulePageIsVisible(), true);
	}

	private void setupPages() {
		schedulePage = new SchedulePage(driver);
		newSchedulingPage = new NewSchedulingPage(driver);
	}

}
