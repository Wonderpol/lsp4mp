/*******************************************************************************
* Copyright (c) 2019 Red Hat Inc. and others.
* All rights reserved. This program and the accompanying materials
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v20.html
*
* SPDX-License-Identifier: EPL-2.0
* 
* Contributors:
*     Red Hat Inc. - initial API and implementation
*******************************************************************************/
package org.eclipse.lsp4mp.ls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.eclipse.lsp4mp.commons.ProjectLabelInfoEntry;
import org.eclipse.lsp4mp.ls.JavaTextDocumentSnippetRegistry;
import org.eclipse.lsp4mp.ls.commons.snippets.ISnippetContext;
import org.eclipse.lsp4mp.ls.commons.snippets.Snippet;
import org.eclipse.lsp4mp.ls.commons.snippets.SnippetRegistry;
import org.eclipse.lsp4mp.snippets.SnippetContextForJava;
import org.junit.Assert;
import org.junit.Test;

/**
 * test for Java snippet registry.
 * 
 * @author Angelo ZERR
 *
 */
public class JavaTextDocumentSnippetRegistryTest {

	private static JavaTextDocumentSnippetRegistry registry = new JavaTextDocumentSnippetRegistry();

	@Test
	public void haveJavaSnippets() {
		Assert.assertFalse("Tests has MicroProfile Java snippets", registry.getSnippets().isEmpty());
	}

	@Test
	public void jaxrsSnippets() {
		Optional<Snippet> jaxrsSnippet = findByPrefix("jaxrc", registry);
		Assert.assertTrue("Tests has jaxrc Java snippets", jaxrsSnippet.isPresent());

		ISnippetContext<?> context = jaxrsSnippet.get().getContext();
		Assert.assertNotNull("jaxrc snippet has context", context);
		Assert.assertTrue("jaxrc snippet context is Java context", context instanceof SnippetContextForJava);

		ProjectLabelInfoEntry projectInfo = new ProjectLabelInfoEntry("", new ArrayList<>());
		boolean match = ((SnippetContextForJava) context).isMatch(projectInfo);
		Assert.assertFalse("Project has no javax.ws.rs.GET type", match);

		ProjectLabelInfoEntry projectInfo2 = new ProjectLabelInfoEntry("",
				Arrays.asList("javax.ws.rs.GET"));
		boolean match2 = ((SnippetContextForJava) context).isMatch(projectInfo2);
		Assert.assertTrue("Project has javax.ws.rs.GET type", match2);
	}

	@Test
	public void mpMetricsSnippets() {
		Optional<Snippet> metricSnippet = findByPrefix("@Metric", registry);
		Assert.assertTrue("Tests has @Metric Java snippets", metricSnippet.isPresent());

		ISnippetContext<?> context = metricSnippet.get().getContext();
		Assert.assertNotNull("@Metric snippet has context", context);
		Assert.assertTrue("@Metric snippet context is Java context", context instanceof SnippetContextForJava);

		ProjectLabelInfoEntry projectInfo = new ProjectLabelInfoEntry("", new ArrayList<>());
		boolean match = ((SnippetContextForJava) context).isMatch(projectInfo);
		Assert.assertFalse("Project has no org.eclipse.microprofile.metrics.annotation.Metric type", match);

		ProjectLabelInfoEntry projectInfo2 = new ProjectLabelInfoEntry("",
				Arrays.asList("org.eclipse.microprofile.metrics.annotation.Metric"));
		boolean match2 = ((SnippetContextForJava) context).isMatch(projectInfo2);
		Assert.assertTrue("Project has org.eclipse.microprofile.metrics.annotation.Metric type", match2);
	}

	@Test
	public void mpOpenAPISnippets() {
		Optional<Snippet> apiResponseSnippet = findByPrefix("@APIResponse", registry);
		Assert.assertTrue("Tests has @APIResponse Java snippets", apiResponseSnippet.isPresent());

		ISnippetContext<?> context = apiResponseSnippet.get().getContext();
		Assert.assertNotNull("@APIResponse snippet has context", context);
		Assert.assertTrue("@APIResponse snippet context is Java context", context instanceof SnippetContextForJava);

		ProjectLabelInfoEntry projectInfo = new ProjectLabelInfoEntry("", new ArrayList<>());
		boolean match = ((SnippetContextForJava) context).isMatch(projectInfo);
		Assert.assertFalse("Project has no org.eclipse.microprofile.openapi.annotations.responses.APIResponse type", match);

		ProjectLabelInfoEntry projectInfo2 = new ProjectLabelInfoEntry("",
				Arrays.asList("org.eclipse.microprofile.openapi.annotations.responses.APIResponse"));
		boolean match2 = ((SnippetContextForJava) context).isMatch(projectInfo2);
		Assert.assertTrue("Project has org.eclipse.microprofile.openapi.annotations.responses.APIResponse type", match2);
	}

	@Test
	public void mpFaultToleranceSnippets() {
		Optional<Snippet> fallbackSnippet = findByPrefix("@Fallback", registry);
		Assert.assertTrue("Tests has @Fallback Java snippets", fallbackSnippet.isPresent());

		ISnippetContext<?> context = fallbackSnippet.get().getContext();
		Assert.assertNotNull("@Fallback snippet has context", context);
		Assert.assertTrue("@Fallback snippet context is Java context", context instanceof SnippetContextForJava);

		ProjectLabelInfoEntry projectInfo = new ProjectLabelInfoEntry("", new ArrayList<>());
		boolean match = ((SnippetContextForJava) context).isMatch(projectInfo);
		Assert.assertFalse("Project has no org.eclipse.microprofile.faulttolerance.Fallback type", match);

		ProjectLabelInfoEntry projectInfo2 = new ProjectLabelInfoEntry("",
				Arrays.asList("org.eclipse.microprofile.faulttolerance.Fallback"));
		boolean match2 = ((SnippetContextForJava) context).isMatch(projectInfo2);
		Assert.assertTrue("Project has org.eclipse.microprofile.faulttolerance.Fallback type", match2);
	}

	@Test
	public void mpHealthSnippets() {
		Optional<Snippet> readinessSnippet = findByPrefix("mpreadiness", registry);
		Assert.assertTrue("Tests has mpreadiness Java snippets", readinessSnippet.isPresent());

		ISnippetContext<?> readinessContext = readinessSnippet.get().getContext();
		Assert.assertNotNull("mpreadiness snippet has context", readinessContext);
		Assert.assertTrue("mpreadiness snippet context is Java context", readinessContext instanceof SnippetContextForJava);

		ProjectLabelInfoEntry readinessProjectInfo = new ProjectLabelInfoEntry("", new ArrayList<>());
		boolean match = ((SnippetContextForJava) readinessContext).isMatch(readinessProjectInfo);
		Assert.assertFalse("Project has no org.eclipse.microprofile.health.Readiness type", match);

		ProjectLabelInfoEntry readinessProjectInfo2 = new ProjectLabelInfoEntry("",
				Arrays.asList("org.eclipse.microprofile.health.Readiness"));
		boolean match2 = ((SnippetContextForJava) readinessContext).isMatch(readinessProjectInfo2);
		Assert.assertTrue("Project has org.eclipse.microprofile.health.Readiness type", match2);

		Optional<Snippet> livenessSnippet = findByPrefix("mpliveness", registry);
		Assert.assertTrue("Tests has mpliveness Java snippets", livenessSnippet.isPresent());
		
		ISnippetContext<?> livenessContext = livenessSnippet.get().getContext();
		Assert.assertNotNull("mpliveness snippet has context", livenessContext);
	}

	@Test
	public void mpRestClientSnippets() {
		Optional<Snippet> newRestClientSnippet = findByPrefix("mpnrc", registry);
		Assert.assertTrue("Tests has new MicroProfile rest client Java snippets", newRestClientSnippet.isPresent());

		ISnippetContext<?> context = newRestClientSnippet.get().getContext();
		Assert.assertNotNull("mpnrc snippet has context", context);
		Assert.assertTrue("mpnrc snippet context is Java context", context instanceof SnippetContextForJava);

		ProjectLabelInfoEntry projectInfo = new ProjectLabelInfoEntry("", new ArrayList<>());
		boolean match = ((SnippetContextForJava) context).isMatch(projectInfo);
		Assert.assertFalse("Project has no org.eclipse.microprofile.rest.client.inject.RegisterRestClient type", match);

		ProjectLabelInfoEntry projectInfo2 = new ProjectLabelInfoEntry("",
				Arrays.asList("org.eclipse.microprofile.rest.client.inject.RegisterRestClient"));
		boolean match2 = ((SnippetContextForJava) context).isMatch(projectInfo2);
		Assert.assertTrue("Project has org.eclipse.microprofile.rest.client.inject.RegisterRestClient type", match2);

		Optional<Snippet> injectRestClientSnippet = findByPrefix("mpirc", registry);
		Assert.assertTrue("Tests has inject MicroProfile rest client Java snippets", injectRestClientSnippet.isPresent());

		ISnippetContext<?> context2 = injectRestClientSnippet.get().getContext();
		Assert.assertNotNull("mpirc snippet has context", context2);
	}

	private static Optional<Snippet> findByPrefix(String prefix, SnippetRegistry registry) {
		return registry.getSnippets().stream().filter(snippet -> snippet.getPrefixes().contains(prefix)).findFirst();
	}
}
