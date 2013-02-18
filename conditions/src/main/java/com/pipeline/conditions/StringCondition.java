/**
 * Copyright Jun 9, 2012 Travis Rasor
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.pipeline.conditions;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Conditions for strings
 * 
 * @author Travis Rasor
 */
public class StringCondition extends ObjectCondition {

    final String string;

    public StringCondition(String str) {
        super(str);
        this.string = str;
    }

    public StringCondition isNotBlankOrEmpty() {
        return isNotBlankOrEmpty(null);
    }

    public StringCondition isNotBlankOrEmpty(String detail) {
        if (StringUtils.isBlank(string) || StringUtils.isEmpty(string)) throwException("empty or not blank", detail);
        return this;
    }

    public StringCondition isNotBlank() {
        return isNotBlank(null);
    }

    public StringCondition isNotBlank(String detail) {
        if (StringUtils.isBlank(string)) throwException("blank", detail);
        return this;
    }

    public StringCondition isBlank() {
        return isBlank(null);
    }

    public StringCondition isBlank(String detail) {
        if (StringUtils.isNotBlank(string)) throwException("not blank", detail);
        return this;
    }

    public StringCondition isNotEmpty() {
        return isNotEmpty(null);
    }

    public StringCondition isNotEmpty(String detail) {
        if (StringUtils.isEmpty(string)) throwException("not empty", detail);
        return this;
    }

    public StringCondition isEmpty() {
        return isEmpty(null);
    }

    public StringCondition isEmpty(String detail) {
        if (StringUtils.isNotEmpty(string)) throwException("empty", detail);
        return this;
    }

    public StringCondition isAllLowerCase() {
        return isAllLowerCase(null);
    }

    public StringCondition isAllLowerCase(String detail) {
        if (!StringUtils.isAllLowerCase(string)) throwException("not all lower case", detail);
        return this;
    }

    public StringCondition isAllUpperCase() {
        if (!StringUtils.isAllUpperCase(string))
            throw new ConditionViolationException("String [" + string + "] was not being all upper case");
        return this;
    }

    public StringCondition isAlpha() {
        return isAlpha(null);
    }

    public StringCondition isAlpha(String detail) {
        if (!StringUtils.isAlpha(string)) throwException("not only alphabetical characters", detail);
        return this;
    }

    public StringCondition isAlphanumeric() {
        return isAlphanumeric(null);
    }

    public StringCondition isAlphanumeric(String detail) {
        if (!StringUtils.isAlphanumeric(string)) throwException("not alphanumeric", detail);
        return this;
    }

    private void throwException(String cause, String detail) {
        String causeStr = new StringBuilder(50).append("[").append(string).append("] was ").append(cause).toString();
        throw new ConditionViolationException(causeStr, detail);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.NO_FIELD_NAMES_STYLE).append("string", string).build();
    }
}
