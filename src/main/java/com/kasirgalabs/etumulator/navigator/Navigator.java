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

import com.google.inject.Singleton;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

@Singleton
public class Navigator extends Observable implements Initializable {
    public static final int DECIMAL = 0;
    public static final int HEX = 1;
    public static final int ASCII = 2;
    public static final int BINARY = 3;

    private static int valueType;
    @FXML
    private ComboBox<String> valueTypeComboBox;

    public static int getValueType() {
        return valueType;
    }

    private static void setValueType(int type) {
        valueType = type;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        valueTypeComboBox.setItems(FXCollections.observableArrayList(
                new String[]{"Decimal", "HEX", "ASCII", "Binary"}));
        valueTypeComboBox.getSelectionModel().select(0);
    }

    @FXML
    private void valueTypeComboBoxOnAction(ActionEvent event) {
        setValueType(valueTypeComboBox.getSelectionModel().getSelectedIndex());
        setChanged();
        notifyObservers();
    }
}
