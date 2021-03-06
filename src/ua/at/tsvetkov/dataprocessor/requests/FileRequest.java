/*******************************************************************************
 * Copyright (c) 2014 Alexandr Tsvetkov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * Contributors:
 *     Alexandr Tsvetkov - initial API and implementation
 *
 * Project:
 *     TAO Data Processor
 *
 * License agreement:
 *
 * 1. This code is published AS IS. Author is not responsible for any damage that can be
 *    caused by any application that uses this code.
 * 2. Author does not give a garantee, that this code is error free.
 * 3. This code can be used in NON-COMMERCIAL applications AS IS without any special
 *    permission from author.
 * 4. This code can be modified without any special permission from author IF AND ONLY IF
 *    this license agreement will remain unchanged.
 ******************************************************************************/
package ua.at.tsvetkov.dataprocessor.requests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import ua.at.tsvetkov.dataprocessor.ProcessingCentre;

/**
 * The main class for the file request building. If not specified the request be built with basic configuration parameters specified in
 * {@link ua.at.tsvetkov.dataprocessor.DataProcessorConfiguration DataProcessorConfiguration}.
 * 
 * @author lordtao
 */
public abstract class FileRequest extends Request {

	private FileInputStream	inputStream;

	protected FileRequest() {

	}

	/**
	 * Starts the request and returns a response data as InputStream
	 * 
	 * @return
	 * @throws IOException
	 */
	public InputStream getInputStream() throws IOException {
		inputStream = new FileInputStream(new File(toString()));
		statusCode = ProcessingCentre.FILE_SUCCESS;
		return inputStream;
	}

	@Override
	public Request build() {
		scheme = "";
		return super.build();
	}

	/**
	 * Release resources associated with this request. You must call this, or significant resources (sockets and memory) may be leaked.
	 */
	@Override
	public void close() throws Exception {
		inputStream.close();
	}

}
