package utilidades;

/**
 * @since 27/11/2017
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

/**
 * @since 27/11/2017
 * @author bgaona
 *
 */
public class LectorExcel {

	/**
	 * Obtiene los datos de un archivo de excel, teniendo en cuenta el nombre de la
	 * hoja
	 * 
	 * @since 27/11/2017
	 * @author bgaona
	 * @param excelFilePath
	 *            Ruta del libro de excel
	 * @param sheetName
	 *            Nombre de la hoja que contiene los datos
	 * @return
	 * @throws InvalidFormatException
	 *             Manejo de error por formato inválido
	 * @throws IOException
	 *             Manejo de error para el proceso de entrada y salida de datos
	 */
	public List<Map<String, String>> getData(String excelFilePath, String sheetName)
			throws InvalidFormatException, IOException {
		Sheet sheet = getSheetByName(excelFilePath, sheetName);
		return readSheet(sheet);
	}

	/**
	 * Obtiene los datos de un archivo de excel, teniendo en cuenta el numero de la
	 * hoja
	 * 
	 * @since 27/11/2017
	 * @author bgaona
	 * @param excelFilePath
	 *            Ruta del libro de excel
	 * @param sheetNumber
	 *            Nombre de la hoja que contiene los datos
	 * @return
	 * @throws InvalidFormatException
	 *             Manejo de error por formato inválido
	 * @throws IOException
	 *             Manejo de error para el proceso de entrada y salida de datos
	 */
	public List<Map<String, String>> getData(String excelFilePath, int sheetNumber)
			throws InvalidFormatException, IOException {
		Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
		return readSheet(sheet);
	}

	/**
	 * Obtiene la hoja de trabajo donde se encuentran los datos de acuerdo a la
	 * ruta del archivo
	 * 
	 * @since 27/11/2017
	 * @author bgaona
	 * @param excelFilePath
	 *            Ruta del libro de excel
	 * @param sheetName
	 *            Nombre de la hoja que contiene los datos
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
		Sheet sheet = getWorkBook(excelFilePath).getSheet(sheetName);
		return sheet;
	}

	/**
	 * Obtiene los hoja de trabajo donde se encuentran los datos de acuerdo al index
	 * de la hoja
	 * 
	 * @since 27/11/2017
	 * @author bgaona
	 * @param excelFilePath
	 *            Ruta del libro de excel
	 * @param sheetNumber
	 *            Indice de tipo entero de la hoja en el libro de excel
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws IOException, InvalidFormatException {
		Sheet sheet = getWorkBook(excelFilePath).getSheetAt(sheetNumber);
		return sheet;
	}

	/**
	 * Devuelve el libro correspondiente a la hoja determinada con antelación
	 * 
	 * @since 27/11/2017
	 * @author bgaona
	 * @param excelFilePath
	 *            Ruta del archivo de excel
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	private Workbook getWorkBook(String excelFilePath) throws IOException, InvalidFormatException {
		return WorkbookFactory.create(new File(excelFilePath));
	}

	/**
	 * Retorna la lista en forma de Map de todas las filas que contiene la hoja de
	 * excel, teniendo en cuenta la primera fila como los nombres de la columna
	 * 
	 * @since 27/11/2017
	 * @author bgaona
	 * @param sheet
	 *            Hoja de excel
	 * @return
	 */
	private List<Map<String, String>> readSheet(Sheet sheet) {
		
		Row row;
		int totalRow = sheet.getPhysicalNumberOfRows(); //-------------> se deja la última fila Se quita una de las filas que la librería considera que tiene datos debido a que deja una en blanco
		List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
		
		int headerRowNumber = getHeaderRowNumber(sheet);
		if (headerRowNumber != -1) {
			int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
			int setCurrentRow = 1;
			for (int currentRow = setCurrentRow; currentRow <= totalRow; currentRow++) {
				row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
				LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
					columnMapdata.putAll(getCellValue(sheet, row, currentColumn));
				}
				excelRows.add(columnMapdata);
			}
		}
		
		return excelRows;
	}

	/**
	 * Obtiene el número de filas conceniernte a encabezado de la hoja
	 * 
	 * @since 27/11/2017
	 * @author bgaona
	 * @param sheet
	 * @return
	 */
	private int getHeaderRowNumber(Sheet sheet) {
		Row row;
		int totalRow = sheet.getLastRowNum();
		for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
			row = getRow(sheet, currentRow);
			if (row != null) {
				int totalColumn = row.getLastCellNum();
				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
					Cell cell;
					cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					if (cell.getCellTypeEnum() == CellType.STRING) {
						return row.getRowNum();
					} else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
						return row.getRowNum();

					} else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
						return row.getRowNum();
					} else if (cell.getCellTypeEnum() == CellType.ERROR) {
						return row.getRowNum();
					}
				}
			}
		}
		return (-1);
	}

	/**
	 * Obtiene la fila de acuerdo a la hoja y el número de ésta
	 * 
	 * @since 27/11/2017
	 * @author bgaona
	 * @param sheet
	 * @param rowNumber
	 * @return
	 */
	private Row getRow(Sheet sheet, int rowNumber) {
		return sheet.getRow(rowNumber);
	}
	
	/**
	 * Obtiene un vector con los datos alojados en la columna de acuerdo a la hoja y el número de ésta
	 * 
	 * @since 04/10/2019
	 * @author irodriguezb
	 * @param strRutaXlsx
	 * @param sheet
	 * @param columna
	 * @return
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 */
	@SuppressWarnings("deprecation")
	public String[] obtenerColumna(String strRutaXlsx, String nombreHoja, int columna) throws InvalidFormatException, IOException {
		List<String> listaProveedores = new ArrayList<String>();
		Workbook miLibro = getWorkBook(strRutaXlsx);
		Sheet sheet = miLibro.getSheet(nombreHoja);
		Row row;
		Cell cell;
		for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			row = sheet.getRow(rowIndex);
			if (row != null) {
				String cellValue = null;
				cell = row.getCell(columna);
				if (cell != null) {
					if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC||cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
						if (HSSFDateUtil.isCellDateFormatted(cell)) {
							Date fecha = cell.getDateCellValue();
							SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
							listaProveedores.add(formateador.format(fecha));
						}else {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							cellValue = cell.getStringCellValue();
							if (!cellValue.trim().isEmpty()) {
								listaProveedores.add(cellValue);
							}
						}
					} else {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						cellValue = cell.getStringCellValue();
						if (!cellValue.trim().isEmpty()) {
							listaProveedores.add(cellValue);
						}
					}
				}
			}
		}
		String[] strValoresColumna = new String[listaProveedores.size()];
		strValoresColumna = listaProveedores.toArray(strValoresColumna);
		miLibro.close();
		return strValoresColumna;
	}
	
	@SuppressWarnings("deprecation")
	public String[] obtenerColumnaPorProveedor(String strRutaXlsx, String nombreHoja, int filaInicial,int filaFinal, int columna,String strProveedor) throws InvalidFormatException, IOException {
		List<String> listaColumna = new ArrayList<String>();
		Workbook miLibro = getWorkBook(strRutaXlsx);
		Sheet sheet = miLibro.getSheet(nombreHoja);
		Row row;
		Cell cell,cellProveedor;
		for (int posVal = filaInicial; posVal < filaFinal; posVal++) {
			row = sheet.getRow(posVal);
			if (row != null) {
				
				cellProveedor = row.getCell(4); // optiene la celda del nit Proveedor
				String cellValueProv = null;
				if (cellProveedor != null   ) {
					cellProveedor.setCellType(Cell.CELL_TYPE_STRING);
					cellValueProv = cellProveedor.getStringCellValue();
					if(cellValueProv.equals(strProveedor)) {  //compara si esa fila corrwsponde al proveedor que se necesita
						cell = row.getCell(columna);
						if (cell == null)
							cell = row.createCell(columna);
						String cellValue = cell.getStringCellValue();
						listaColumna.add(cellValue);
					}
				}
			}
		}
	    miLibro.close();
	    String[] strValoresColumna = new String[listaColumna.size()];
		strValoresColumna = listaColumna.toArray(strValoresColumna);
		return strValoresColumna;
	}
	
	/**
	 * Obtiene el valor de cada una de las celdas -------> reevaluar y dejar como texto todos los valores
	 * 
	 * @since 27/11/2017
	 * @author bgaona
	 * @param sheet
	 * @param row
	 * @param currentColumn
	 * @return
	 */
	private LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn) {
		LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
		Cell cell;
		if (row == null) {
			if (sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
					.getCellTypeEnum() != CellType.BLANK) {
				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
						.getStringCellValue();
				columnMapdata.put(columnHeaderName, "");
			}
		} else {
			cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			if (cell.getCellTypeEnum() == CellType.STRING) {
				if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getCellTypeEnum() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, cell.getStringCellValue());
				}
			} else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
				if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getCellTypeEnum() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
				}
			} else if (cell.getCellTypeEnum() == CellType.BLANK) {
				if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getCellTypeEnum()!= CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, "");
				}
			} else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
				if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getCellTypeEnum() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
				}
			} else if (cell.getCellTypeEnum() == CellType.ERROR) {
				if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getCellTypeEnum() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
				}
			}
		}
		return columnMapdata;
	}
	
	public static void copiarArchivo(String origenArchivo, String destinoArchivo) throws IOException {
            Path origenPath = Paths.get(origenArchivo);
            Path destinoPath = Paths.get(destinoArchivo);
            //sobreescribir el fichero de destino si existe y lo copia
            Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
    }
	
	/* inserta un vector en una fila y columna indicada
	 * 
	 * @param strRutaXlsx ruta del archivo xlsx
	 * @param nombreHoja hoja donde se inserta el vector
	 * @param valoresCol valores que se insertaran
	 * @param filaInicial :fila desde donde empezara a insertar
	 * @param columna : columna en la cual se insertara el vector
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @throws ParseException 
	 */
	@SuppressWarnings("deprecation")
	public static void llenarColumna(String strRutaXlsx, String nombreHoja,String[]valoresCol ,int filaInicial, int columna, String formatoCeldas) throws InvalidFormatException, IOException, ParseException {
		FileInputStream inputStream = new FileInputStream(strRutaXlsx);
		Workbook miLibro = WorkbookFactory.create(inputStream);
		Sheet sheet = miLibro.getSheet(nombreHoja);
		Row row;
		Cell cell;
		for (int posVal = 0; posVal < valoresCol.length; posVal++) {
			row = sheet.getRow(filaInicial);
			if (row == null) {
				row = sheet.createRow(filaInicial);
			}
			cell = row.getCell(columna);
			if (cell == null)
				cell = row.createCell(columna);
			if(!formatoCeldas.trim().isEmpty()) {
				CellStyle cellStyle = miLibro.createCellStyle(); 
				 CreationHelper createHelper = miLibro.getCreationHelper();  
	            cellStyle.setDataFormat(createHelper.createDataFormat().getFormat(formatoCeldas));
	            cell.setCellStyle(cellStyle);  
			}
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cell.setCellValue(valoresCol[posVal]);

			filaInicial++;
		}
		inputStream.close();
		FileOutputStream fileOut = new FileOutputStream(strRutaXlsx);
		miLibro.write(fileOut);
	    fileOut.close();
	    miLibro.close();
	}
	
	@SuppressWarnings("deprecation")
	public static void llenarColumnaFormula(String strRutaXlsx, String nombreHoja,String[]valoresCol ,int filaInicial, int columna, String formatoCeldas) throws InvalidFormatException, IOException {
		FileInputStream inputStream = new FileInputStream(strRutaXlsx);
		Workbook miLibro = WorkbookFactory.create(inputStream);
		Sheet sheet = miLibro.getSheet(nombreHoja);
		Row row;
		Cell cell;
		for (int posVal = 0; posVal < valoresCol.length; posVal++) {
			row = sheet.getRow(filaInicial);
			if (row == null) {
				row = sheet.createRow(filaInicial);
			}
			cell = row.getCell(columna);
			if (cell == null)
				cell = row.createCell(columna);
			if(!formatoCeldas.trim().isEmpty()) {
				CellStyle cellStyle = miLibro.createCellStyle(); 
				 CreationHelper createHelper = miLibro.getCreationHelper();  
	            cellStyle.setDataFormat(createHelper.createDataFormat().getFormat(formatoCeldas));
	            cell.setCellStyle(cellStyle);  
			}
			cell.setCellType(cell.getCellType());
			cell.setCellFormula(valoresCol[posVal]);
			
			filaInicial++;
		}
		inputStream.close();
		FileOutputStream fileOut = new FileOutputStream(strRutaXlsx);
		miLibro.write(fileOut);
	    fileOut.close();
	    miLibro.close();
	}
	
	@SuppressWarnings("deprecation")
	public static void insertarValoresdeProveedorEspecifico(String strRutaXlsx, String nombreHoja,String Proveedor, String valor ,int filaInicial,int filaFinal, int columna, String formatoCeldas) throws InvalidFormatException, IOException {
		FileInputStream inputStream = new FileInputStream(strRutaXlsx);
		Workbook miLibro = WorkbookFactory.create(inputStream);
		Sheet sheet = miLibro.getSheet(nombreHoja);
		Row row;
		Cell cell,cellProveedor;
		for (int posVal = 0; posVal < filaFinal; posVal++) {
			row = sheet.getRow(filaInicial);
			if (row == null) {
				row = sheet.createRow(filaInicial);
			}

			cellProveedor = row.getCell(4); // optiene la celda del nit Proveedor
			String cellValueProv = null;
			if (cellProveedor != null) {
				cellProveedor.setCellType(Cell.CELL_TYPE_STRING);
				cellValueProv = cellProveedor.getStringCellValue();
				if (cellValueProv.equals(Proveedor)) { // compara si esa fila corrwsponde al proveedor que se necesita
					cell = row.getCell(columna);
					if (cell == null)
						cell = row.createCell(columna);
					if(!formatoCeldas.trim().isEmpty()) {
						CellStyle cellStyle = miLibro.createCellStyle(); 
						 CreationHelper createHelper = miLibro.getCreationHelper();  
			            cellStyle.setDataFormat(createHelper.createDataFormat().getFormat(formatoCeldas));
			            cell.setCellStyle(cellStyle);  
					}
					cell.setCellType(Cell.CELL_TYPE_STRING);
					cell.setCellValue(valor);
				}
			}

			filaInicial++;
		}
		inputStream.close();
		FileOutputStream fileOut = new FileOutputStream(strRutaXlsx);
		miLibro.write(fileOut);
	    fileOut.close();
	    miLibro.close();
	}
	
	@SuppressWarnings("deprecation")
	public static void insertarValoresdeProveedorEspecifico(String strRutaXlsx, String nombreHoja,String Proveedor,int columnaProve, String valor ,int filaInicial,int filaFinal, int columna, String formatoCeldas) throws InvalidFormatException, IOException {
		FileInputStream inputStream = new FileInputStream(strRutaXlsx);
		Workbook miLibro = WorkbookFactory.create(inputStream);
		Sheet sheet = miLibro.getSheet(nombreHoja);
		Row row;
		Cell cell,cellProveedor;
		for (int posVal = 0; posVal < filaFinal; posVal++) {
			row = sheet.getRow(filaInicial);
			if (row == null) {
				row = sheet.createRow(filaInicial);
			}

			cellProveedor = row.getCell(columnaProve); // optiene la celda del nit Proveedor
			String cellValueProv = null;
			if (cellProveedor != null) {
				cellProveedor.setCellType(Cell.CELL_TYPE_STRING);
				cellValueProv = cellProveedor.getStringCellValue();
				if (cellValueProv.equals(Proveedor)) { // compara si esa fila corrwsponde al proveedor que se necesita
					cell = row.getCell(columna);
					if (cell == null)
						cell = row.createCell(columna);
					if(!formatoCeldas.trim().isEmpty()) {
						CellStyle cellStyle = miLibro.createCellStyle(); 
						 CreationHelper createHelper = miLibro.getCreationHelper();  
			            cellStyle.setDataFormat(createHelper.createDataFormat().getFormat(formatoCeldas));
			            cell.setCellStyle(cellStyle);  
					}
					cell.setCellType(Cell.CELL_TYPE_STRING);
					cell.setCellValue(valor);
				}
			}

			filaInicial++;
		}
		inputStream.close();
		FileOutputStream fileOut = new FileOutputStream(strRutaXlsx);
		miLibro.write(fileOut);
	    fileOut.close();
	    miLibro.close();
	}
	
	/*@SuppressWarnings("deprecation")
	public static void llenarDiasAdicionalesSinCosto(String strRutaXlsx, String nombreHoja,String Proveedor, int sumaDias ,int filaInicial,int filaFinal, int columna,String[] fechasCalendarioPago) throws InvalidFormatException, IOException, ParseException {
		FileInputStream inputStream = new FileInputStream(strRutaXlsx);
		Workbook miLibro = WorkbookFactory.create(inputStream);
		Sheet sheet = miLibro.getSheet(nombreHoja);
		Row row;
		Cell cell,cellProveedor,cellfechaVcto;
		for (int posVal = filaInicial; posVal < filaFinal; posVal++) {
			row = sheet.getRow(filaInicial);
			if (row == null) {
				row = sheet.createRow(filaInicial);
			}
			cellProveedor = row.getCell(4); // optiene la celda del nit Proveedor
			cellfechaVcto = row.getCell(10); // optiene la celda de la fecha de vencimiento
			String cellValueProv = null, cellValueFecha = null;
			if (cellProveedor != null) {
				cellValueProv = obtenerValorCelda(cellProveedor);
				cellValueFecha = obtenerValorCelda(cellfechaVcto);
				if (cellValueProv.equals(Proveedor)) { // compara si esa fila corrwsponde al proveedor que se necesita
					int acomuladoSuma = 0;
					if (fechasCalendarioPago != null) {
						acomuladoSuma =sumaDias+ CuadroOperativo.obtenerNumDiasdiferenciaCalendarioPago(cellValueFecha, sumaDias, fechasCalendarioPago);
					}else {
						acomuladoSuma =sumaDias;
					}
					cell = row.getCell(columna);
					if (cell == null)
						cell = row.createCell(columna);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					cell.setCellValue(acomuladoSuma);
				}
			}
			filaInicial++;
		}
		inputStream.close();
		FileOutputStream fileOut = new FileOutputStream(strRutaXlsx);
		miLibro.write(fileOut);
	    fileOut.close();
	    miLibro.close();
	}*/
	
	@SuppressWarnings("deprecation")
	public static String obtenerValorCelda(Cell cell) {
		String cellValue;
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cellValue = cell.getStringCellValue();
		return cellValue;
	}
	
	@SuppressWarnings("deprecation")
	public static void llenarHashMapEnExcel(String strRutaXlsx, String nombreHoja,String Proveedor, int filaInicial,int filaFinal, int columna, HashMap<String,String> listaNomDoc_Contrato) throws InvalidFormatException, IOException, ParseException {
		FileInputStream inputStream = new FileInputStream(strRutaXlsx);
		Workbook miLibro = WorkbookFactory.create(inputStream);
		Sheet sheet = miLibro.getSheet(nombreHoja);
		Row row;
		Cell cell,cellProveedor,cellNomDocumento;
		for (int posVal = filaInicial; posVal < filaFinal; posVal++) {
			row = sheet.getRow(posVal);
			if (row == null) {
				row = sheet.createRow(filaInicial);
			}
			cellProveedor = row.getCell(4); // optiene la celda del nit Proveedor
			cellNomDocumento = row.getCell(8); // optiene la celda de la nombreDocumento
			String cellValueProv = null, cellNomDoc = null;
			if (cellProveedor != null) {
				cellValueProv = obtenerValorCelda(cellProveedor);
				cellNomDoc = obtenerValorCelda(cellNomDocumento);
				if (cellValueProv.equals(Proveedor)) { // compara si esa fila corrwsponde al proveedor que se necesita
					String contrato = "";
					contrato = listaNomDoc_Contrato.get(cellNomDoc);
					cell = row.getCell(columna);
					if (cell == null)
						cell = row.createCell(columna);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					cell.setCellValue(contrato);
				}
			}

		}
		inputStream.close();
		FileOutputStream fileOut = new FileOutputStream(strRutaXlsx);
		miLibro.write(fileOut);
	    fileOut.close();
	    miLibro.close();
	}
}

