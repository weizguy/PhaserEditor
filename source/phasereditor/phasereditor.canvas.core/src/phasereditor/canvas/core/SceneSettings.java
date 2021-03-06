// The MIT License (MIT)
//
// Copyright (c) 2015, 2016 Arian Fornaris
//
// Permission is hereby granted, free of charge, to any person obtaining a
// copy of this software and associated documentation files (the
// "Software"), to deal in the Software without restriction, including
// without limitation the rights to use, copy, modify, merge, publish,
// distribute, sublicense, and/or sell copies of the Software, and to permit
// persons to whom the Software is furnished to do so, subject to the
// following conditions: The above copyright notice and this permission
// notice shall be included in all copies or substantial portions of the
// Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
// OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
// NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
// DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
// OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE
// USE OR OTHER DEALINGS IN THE SOFTWARE.
package phasereditor.canvas.core;

import java.util.Arrays;

import org.eclipse.swt.graphics.RGB;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author arian
 */
public class SceneSettings {
	private double _sceneWidth;
	private double _sceneHeight;
	private RGB _sceneColor;
	private boolean _generateOnSave;
	private boolean _enableStepping;
	private int _stepWidth;
	private int _stepHeight;

	public SceneSettings() {
		_sceneWidth = 640;
		_sceneHeight = 360;
		_sceneColor = null;
		_generateOnSave = true;
		_enableStepping = false;
		_stepWidth = 32;
		_stepHeight = 32;
	}

	public SceneSettings(JSONObject settingsData) {
		read(settingsData);
	}

	public double getSceneWidth() {
		return _sceneWidth;
	}

	public void setSceneWidth(double sceneWidth) {
		_sceneWidth = sceneWidth;
	}

	public double getSceneHeight() {
		return _sceneHeight;
	}

	public void setSceneHeight(double sceneHeight) {
		_sceneHeight = sceneHeight;
	}

	public RGB getSceneColor() {
		return _sceneColor;
	}

	public void setSceneColor(RGB sceneColor) {
		_sceneColor = sceneColor;
	}

	public boolean isGenerateOnSave() {
		return _generateOnSave;
	}

	public void setGenerateOnSave(boolean generateOnScave) {
		_generateOnSave = generateOnScave;
	}

	public boolean isEnableStepping() {
		return _enableStepping;
	}

	public void setEnableStepping(boolean enableStepping) {
		_enableStepping = enableStepping;
	}

	public int getStepWidth() {
		return _stepWidth;
	}

	public void setStepWidth(int stepWidth) {
		_stepWidth = stepWidth;
	}

	public int getStepHeight() {
		return _stepHeight;
	}

	public void setStepHeight(int stepHeight) {
		_stepHeight = stepHeight;
	}

	@SuppressWarnings("boxing")
	public void write(JSONObject obj) {
		obj.put("sceneWidth", _sceneWidth);
		obj.put("sceneHeight", _sceneHeight);
		if (_sceneColor == null) {
			obj.put("sceneColor", (Object) null);
		} else {
			obj.put("sceneColor", Arrays.asList(_sceneColor.red, _sceneColor.green, _sceneColor.blue));
		}
		obj.put("generateOnSave", _generateOnSave);
		obj.put("enableStepping", _enableStepping);
		obj.put("stepWidth", _stepWidth, 32);
		obj.put("stepHeight", _stepHeight, 32);
	}

	public void read(JSONObject obj) {
		{
			JSONArray array = obj.optJSONArray("sceneColor");
			_sceneColor = array == null ? null : new RGB(array.getInt(0), array.getInt(1), array.getInt(2));
		}
		_sceneWidth = obj.getDouble("sceneWidth");
		_sceneHeight = obj.getDouble("sceneHeight");
		_generateOnSave = obj.getBoolean("generateOnSave");
		_enableStepping = obj.optBoolean("enableStepping", false);
		_stepWidth = obj.optInt("stepWidth", 32);
		_stepHeight = obj.optInt("stepHeight", 32);
	}
}
