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
package com.kasirgalabs.etumulator;

import com.google.inject.Inject;
import com.kasirgalabs.etumulator.document.Document;
import com.kasirgalabs.etumulator.langtools.ExecutableCode;
import com.kasirgalabs.etumulator.langtools.LinkerAndLoader;
import com.kasirgalabs.etumulator.processor.Memory;
import com.kasirgalabs.etumulator.processor.Processor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ETUmulatorController {
    @Inject
    private Document document;
    @Inject
    private Processor processor;
    @Inject
    private Memory memory;

    @FXML
    private void runButtonOnAction(ActionEvent event) {
        LinkerAndLoader linkerAndLoader = new LinkerAndLoader(memory);
        ExecutableCode executableCode = linkerAndLoader.linkAndLoad(document.getText() + "\n");
        if(executableCode == null) {
            return;
        }
        processor.run(executableCode);
    }
}
