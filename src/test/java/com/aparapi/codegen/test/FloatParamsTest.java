/**
 * Copyright (c) 2016 - 2017 Syncleus, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aparapi.codegen.test;

import org.junit.Test;

public class FloatParamsTest extends com.aparapi.codegen.CodeGenJUnitBase {
    private static final String[] expectedOpenCL = {
    "typedef struct This_s{\n" +
            '\n' +
" int passid;\n" +
" }This;\n" +
" int get_pass_id(This *this){\n" +
" return this->passid;\n" +
" }\n" +
            '\n' +
" int com_aparapi_codegen_test_FloatParams__addEmUp(This *this, float y, float z){\n" +
" return(((int)y + (int)z));\n" +
" }\n" +
" __kernel void run(\n" +
" int passid\n" +
" ){\n" +
" This thisStruct;\n" +
" This* this=&thisStruct;\n" +
" this->passid = passid;\n" +
" {\n" +
" int y = 2;\n" +
" float x = 0.0f;\n" +
" com_aparapi_codegen_test_FloatParams__addEmUp(this, x=(float)y, x);\n" +
" return;\n" +
" }\n" +
" }\n" +
            ' '};
    private static final Class<? extends com.aparapi.internal.exception.AparapiException> expectedException = null;

    @Test
    public void FloatParamsTest() {
        test(com.aparapi.codegen.test.FloatParams.class, expectedException, expectedOpenCL);
    }

    @Test
    public void FloatParamsTestWorksWithCaching() {
        test(com.aparapi.codegen.test.FloatParams.class, expectedException, expectedOpenCL);
    }
}
