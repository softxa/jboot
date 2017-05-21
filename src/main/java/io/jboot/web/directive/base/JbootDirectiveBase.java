/**
 * Copyright (c) 2015-2017, Michael Yang 杨福海 (fuhai999@gmail.com).
 * <p>
 * Licensed under the GNU Lesser General Public License (LGPL) ,Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jboot.web.directive.base;

import com.jfinal.template.Directive;
import com.jfinal.template.stat.Scope;

import java.util.Map;


public abstract class JbootDirectiveBase extends Directive {

    public <T> T getMapParam(String key, T defaultValue, Scope s) {
        if (exprList == null || exprList.length() == 0) {
            return defaultValue;
        }

        Map map = (Map) exprList.getExprArray()[0].eval(s);
        Object data = map.get(key);
        return (T) (data == null ? defaultValue : data);
    }


    public <T> T getMapParam(String key, Scope s) {
        return getMapParam(key, null, s);
    }


    public <T> T getParam(int index, T defaultValue, Scope s) {
        Object data = exprList.getExprArray()[index].eval(s);
        return (T) (data == null ? defaultValue : data);
    }


    public <T> T getParam(int index, Scope s) {
        return getParam(index, null, s);
    }

}
