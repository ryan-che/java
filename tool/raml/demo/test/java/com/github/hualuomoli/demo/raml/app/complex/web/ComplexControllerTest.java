package com.github.hualuomoli.demo.raml.app.complex.web;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.github.hualuomoli.tool.raml.AbstractContextControllerTest;

public class ComplexControllerTest extends AbstractContextControllerTest {

	@Override
	protected String getControllerRequestUrl() {
		return "/app/complex";
	}

	@Test
	public void testPostUriformById() throws Exception {
		String path = this.getClass().getResource(".").getPath();
		String data = FileUtils.readFileToString(new File(path, "demo.json"), "UTF-8");

		mockMvc.perform(this.json("/uriform/{id}", 1) //
				.content(data))//
				// .andDo(this.print())//
				.andDo(this.showResult()) //
				.andExpect(this.statusOk())//
				.andExpect(this.resultJson())//
				.andExpect(this.resultSuccess())//
				.andReturn();
	}

}
