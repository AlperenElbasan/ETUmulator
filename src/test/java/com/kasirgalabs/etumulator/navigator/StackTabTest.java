/*
 * Copyright (C) 2017 Kasirgalabs
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.kasirgalabs.etumulator.navigator;

import com.kasirgalabs.etumulator.JavaFXThread;
import com.kasirgalabs.etumulator.document.BaseDocumentTest;
import com.kasirgalabs.etumulator.processor.Stack;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class StackTabTest {
    private static Stack stack;
    private static Navigator navigator;
    private static StackTab stackTab;
    @Rule
    public final JavaFXThread javaFXThread = new JavaFXThread();

    @Before
    public void setUp() throws IOException {
        stack = new Stack();
        navigator = new Navigator();
        stackTab = new StackTab(stack, navigator);
        ClassLoader classLoader = BaseDocumentTest.class.getClassLoader();
        FXMLLoader fxmlLoader = new FXMLLoader(classLoader.getResource("fxml/StackTab.fxml"));
        fxmlLoader.setControllerFactory((Class<?> param) -> {
            return stackTab;
        });
        fxmlLoader.load();
    }

    /**
     * Test of update method, of class StackTab.
     */
    @Test
    public void testUpdate() {
        final int RANDOM = (int) (Math.random() * Integer.MAX_VALUE);
        stack.notifyObservers("pop");
        stack.push(RANDOM);
        navigator.notifyObservers();
    }
}
