/*******************************************************************************
 * This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Peter Smith
 *******************************************************************************/
package org.boris.winrun4j.test.unit;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.boris.commons.io.ProcessResult;
import org.boris.winrun4j.DDE;
import org.boris.winrun4j.Launcher;
import org.boris.winrun4j.test.framework.TestHelper;
import org.junit.Test;

/**
 * Test DDE messages.
 */
public class DDETest
{
    @Test
    public void testActivationListener() throws Exception {
        Launcher l = TestHelper.launcher();
        l.main(DDEListener.class);
        l.dde(true, DDE.class);
        l.singleInstance("dde");
        l.fileAss(".fte", "File Association Test", "Testing file assocations");
        String result = TestHelper.run(l, "--WinRun4J:RegisterFileAssociations");
        assertTrue(result.contains("[info] Registering .fte"));
        File f = l.getLauncher();
        FileAssociationsTest.validateFileAssociation(f, ".fte", "File Association Test");
        final File fte = File.createTempFile("something", ".fte");
        final File quit = File.createTempFile("something", ".quit.fte");
        ProcessResult pr = TestHelper.start(l);
        Thread.sleep(1000);
        launch(fte);
        launch(fte);
        Thread.sleep(1000);
        TestHelper.start(l, quit.getAbsolutePath());
        Thread.sleep(1000);
        pr.waitFor();
        result = pr.getStdStr();
        System.out.println(result);
    }

    public void launch(File f) throws IOException {
        Runtime.getRuntime().exec(
                new String[] { System.getenv("windir") + "\\system32\\rundll32.exe",
                        "shell32.dll,ShellExec_RunDLL", f.getAbsolutePath() });
    }

    public static void main(String[] args) throws Exception {
        new DDETest().testActivationListener();
    }
}
