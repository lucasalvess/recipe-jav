package test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.dasa.recipe.servlet.SalvaReceitaController;
import test.mocks.HttpServletResponseStub;
import test.mocks.RecipeRequestStub;

public class SalvaReceitaControllerTest extends SalvaReceitaController{
	
	private static final String PAINEL_CONTROLLER = "painelController";
	
	private static final HttpServletResponseStub servletStub = new HttpServletResponseStub();
	private static final RecipeRequestStub requestStup = new RecipeRequestStub();
	private static final TestStatistic statistics = new TestStatistic();

	public void doPost_validRequestParameters_thenCallPainelController()  {
		try {
			this.doPost(requestStup, servletStub);
			statistics.success();
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			statistics.fail();
		}
	}
}
