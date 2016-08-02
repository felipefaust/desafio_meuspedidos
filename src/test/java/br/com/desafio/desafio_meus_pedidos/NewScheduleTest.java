package br.com.desafio.desafio_meus_pedidos;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.desafio.desafio_meus_pedidos.NewSchedulePage;
import br.com.desafio.desafio_meus_pedidos.SchedulePage;

public class NewScheduleTest extends BaseTest {
	private static final String COSTUMER_NAME = "Supermercado do Bairro";
	private static final String EMPTY_LIST_TEXT = "Não possui atividade.";
	private static final String NOTE_TEXT = "Teste de observação!@123";
	private static final String SUCCESS_TEXT_SAVE = "Ligação cadastrada com sucesso!";
	private static final String TEXT_NOTE_CALL = "teste observacao 123";
	private SchedulePage schedulePage;
	private NewSchedulePage newSchedulegPage;

	@Test
	public void scheduleTest() {
		setupPages();
		openAndValidateSchedule();
		createAndValidateScheduling();
		validateListScheduling();
		setDoneAndCommentCall();
		deleteAndValidateScheduleHasBeenDeleted();
	}

	private void setDoneAndCommentCall() {
		schedulePage.setDoneCall();
		Assert.assertEquals(schedulePage.callIsDone(), true);
		schedulePage.commentCall(TEXT_NOTE_CALL);
		schedulePage.alterScheduleClick();
		Assert.assertEquals(newSchedulegPage.newScheduleIsVisible(), true);
		Assert.assertEquals(schedulePage.getCommentCall(), TEXT_NOTE_CALL);
		newSchedulegPage.closeScheduleModal();
	}

	private void deleteAndValidateScheduleHasBeenDeleted() {
		schedulePage.alterScheduleClick();
		newSchedulegPage.deleteScheduling();
		Assert.assertEquals(schedulePage.getTextToListScheduleEmpty(), EMPTY_LIST_TEXT);
	}

	private void validateListScheduling() {
		Assert.assertEquals(schedulePage.getTextToNoteItemListSchedule(), NOTE_TEXT);
	}

	private void createAndValidateScheduling() {
		openAndValidateScheduling();
		newSchedulegPage.typeCallOptionClick();
		setAndValidadeCostumer();
		newSchedulegPage.noteSendKeys(NOTE_TEXT);
		saveAndValidadeScheduling();
	}

	private void saveAndValidadeScheduling() {
		newSchedulegPage.clickSave();
		Assert.assertEquals(schedulePage.toasterSuccessIsVisible(), SUCCESS_TEXT_SAVE);
	}

	private void setAndValidadeCostumer() {
		newSchedulegPage.setCostumer(COSTUMER_NAME);
		Assert.assertEquals(newSchedulegPage.costumerSelectedIsVisible(), true);
	}

	private void openAndValidateScheduling() {
		schedulePage.newScheduleButtonClick();
		Assert.assertEquals(newSchedulegPage.newScheduleIsVisible(), true);
	}

	private void openAndValidateSchedule() {
		schedulePage.goToSchedulePage();
		Assert.assertEquals(schedulePage.schedulePageIsVisible(), true);
	}

	private void setupPages() {
		schedulePage = new SchedulePage(driver);
		newSchedulegPage = new NewSchedulePage(driver);
	}

}
