/**
 * @author : 孙留平
 * @since : 2018年9月11日 下午2:54:26
 * @see:
 */
package com.testservice.platform.util.core;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.testservice.platform.util.exception.base.BusinessValidationException;

/**
 * @author : Administrator
 * @since : 2018年9月11日 下午2:54:26
 * @see :
 */
public class FileUtil {
	private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

	private FileUtil() {

	}

	/**
	 * doc文档类型
	 */
	public static final String MS_DOC = ".doc";
	/**
	 * docx文档类型
	 */
	public static final String MS_DOCX = ".docx";

	/**
	 * PPT类型
	 */
	public static final String MS_PPT = ".ppt";

	/**
	 * pptx文档类型
	 */
	public static final String MS_PPTX = ".pptx";

	/**
	 * PDF文档类型
	 */
	public static final String PDF = ".pdf";

	/**
	 * txt文档类型
	 */
	public static final String TXT = ".txt";

	/**
	 * WEB-INF文件夹
	 */
	public static final String WEB_INF_FOLDER = "WEB-INF";

	/**
	 * filesandfolders
	 */
	public static List<File> filesAndFolders = new ArrayList<>();

	/**
	 * only files
	 */
	public static List<File> onlyFiles = new ArrayList<>();

	/**
	 * only folders
	 */
	public static List<File> onlyFolders = new ArrayList<>();

	/**
	 * 复制文件
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param fromFile
	 * @param toFile
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void copyFile(File fromFile, File toFile)
	        throws FileNotFoundException, IOException {
		FileInputStream fileInputStream = new FileInputStream(fromFile);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(
		        fileInputStream);
		FileOutputStream fileOutputStream = new FileOutputStream(toFile);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
		        fileOutputStream);
		IOUtils.copy(bufferedInputStream, bufferedOutputStream);
		bufferedInputStream.close();
		fileInputStream.close();

		bufferedOutputStream.close();
		fileOutputStream.close();
	}

	private static String getFileSuffix(String uploadFileName) {
		return uploadFileName.substring(uploadFileName.lastIndexOf("."));
	}

	/**
	 * 创建文件名称
	 * 
	 * @see :
	 * @param :
	 * @return : String
	 * @param fileName
	 * @return
	 */
	public static String createStoreFileName(String fileName) {
		return new StringBuffer()
		        .append(Calendar.getInstance().get(Calendar.HOUR_OF_DAY))
		        .append(Calendar.getInstance().get(Calendar.MINUTE))
		        .append(Calendar.getInstance().get(Calendar.SECOND))
		        // .append(Calendar.getInstance().get(Calendar.MILLISECOND)).append((int)
		        // (Math.random() * 1000))
		        .append(Calendar.getInstance().get(Calendar.MILLISECOND))
		        .append(new Random().nextInt(1000))
		        .append(getFileSuffix(fileName)).toString();
	}

	/**
	 * 获取class文件路径
	 * 
	 * @see :
	 * @param :
	 * @return : String
	 * @return
	 */
	private static String getWebClassesPath() {
		return FileUtil.class.getProtectionDomain().getCodeSource()
		        .getLocation().getPath();

	}

	/**
	 * 验证附件类型是否要进行转换
	 * 
	 * @see :
	 * @param :
	 * @return : boolean
	 * @param fileName
	 * @return
	 */
	public static boolean isVaildateFileConverter(String fileName) {
		if (null == fileName) {
			return false;
		} else if (fileName.toLowerCase().endsWith(MS_DOC)
		        || fileName.toLowerCase().endsWith(MS_DOCX)
		        || fileName.toLowerCase().endsWith(MS_PPT)
		        || fileName.toLowerCase().endsWith(MS_PPTX)
		        || fileName.toLowerCase().endsWith(PDF)
		        || fileName.toLowerCase().endsWith(TXT)) {
			return true;
		} else {
			return false;
		}
	}

	public static String getWebRoot() throws BusinessValidationException {
		String path = getWebClassesPath();
		if (path.indexOf(WEB_INF_FOLDER) > 0) {
			path = path.substring(0, path.indexOf(WEB_INF_FOLDER) - 1);
		} else {
			throw new BusinessValidationException("路径获取错误");
		}
		return path;
	}

	public static String[] createStoreFilePath(String storeFileDir,
	        String tmpFileName) {
		String fileWebPath = new StringBuffer(storeFileDir)
		        .append(File.separator)
		        .append(getFileSuffix(tmpFileName).substring(1).toLowerCase())
		        .append(File.separator)
		        .append(Calendar.getInstance().get(Calendar.YEAR))
		        .append(File.separator)
		        .append(Calendar.getInstance().get(Calendar.MONTH) + 1)
		        .append(File.separator)
		        .append(Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
		        .toString();
		String storedFilePath = new StringBuffer(getWebRoot())
		        .append(File.separator).append(fileWebPath).toString();
		File file = new File(storedFilePath);
		if (!file.isDirectory()) {
			file.mkdirs();
		}
		return new String[] { storedFilePath, fileWebPath };
	}

	public static File createFile(String url, String storedPath,
	        String storedFileName) {
		String[] urlarray = url.split("//");
		url = urlarray[0] + "//" + urlarray[1].replace("\\", "/");
		OutputStream os = null;
		InputStream is = null;
		File file = null;
		try {
			URL location = new URL(url);
			URLConnection con = location.openConnection();
			con.setConnectTimeout(5 * 1000);
			is = con.getInputStream();
			file = new File(storedPath + File.separator + storedFileName);
			os = new FileOutputStream(file);
			byte[] b = new byte[1024];
			int bytesRead = 0;
			while ((bytesRead = is.read(b)) != -1) {
				os.write(b, 0, bytesRead);
			}
			return file;
		} catch (Exception e) {
			logger.error("创建文件异常:{}", e.getMessage());
			return null;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error("关闭文件失败:{}", e.getMessage());
				}
			}

			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					logger.error("关闭文件失败:{}", e.getMessage());
				}
			}
		}
	}

	/**
	 * @see 读取文件
	 */
	public static String readFile(String filePath) {
		final StringBuilder sBuilder = new StringBuilder();
		String line = null;
		File file = new File(filePath);
		try (BufferedReader inputStreamReader = new BufferedReader(
		        new InputStreamReader(new FileInputStream(file)));) {
			while (null != (line = inputStreamReader.readLine())) {
				sBuilder.append(line + "\n");
			}
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		logger.debug("文件:{},的内容为:{}", filePath, sBuilder.toString());
		return sBuilder.toString();
	}

	/**
	 * 写入文件
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param file
	 * @param objectList
	 */
	public static void writeListToFile(File file, List<Object> objectList) {
		BufferedWriter bufferedWriter = null;

		if (objectList.isEmpty()) {
			return;
		}

		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			for (Object object : objectList) {
				bufferedWriter.write(object.toString() + "\n");
			}
			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (Exception e) {
			logger.error("写入文件失败:{}", e.getMessage());
		} finally {
			if (null != bufferedWriter) {
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					logger.error("关闭文件失败:{}", e.getMessage());
				}
			}
		}
	}

	/**
	 * 写入文件
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param file
	 * @param objectList
	 */
	public static void writeStringListToFile(File file,
	        List<String> objectList) {
		BufferedWriter bufferedWriter = null;

		if (objectList.isEmpty()) {
			return;
		}

		// try {
		// bufferedWriter = new BufferedWriter(new FileWriter(file));
		// for (Object object : objectList) {
		// bufferedWriter.write(object.toString() + "\n");
		// }
		// bufferedWriter.flush();
		// bufferedWriter.close();
		// } catch (Exception e) {
		// logger.error("写入文件失败:{}", e.getMessage());
		// throw e;
		// } finally {
		// if (null != bufferedWriter) {
		// try {
		// bufferedWriter.close();
		// } catch (IOException e) {
		// logger.error("关闭文件失败:{}", e.getMessage());
		// e.printStackTrace();
		// }
		// }
		// }

		if (!file.exists()) {
			try {
				boolean createdSuccessully = file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			for (Object object : objectList) {
				bufferedWriter.write(object.toString() + "\n");
			}

			bufferedWriter.flush();
		} catch (IOException e) {
			logger.error("操作流失败:{}", e.getMessage());
		}

		try {
			if (null != bufferedWriter) {
				bufferedWriter.close();
			}

		} catch (IOException e) {
			logger.error("关闭流失败:{}", e.getMessage());
		}
	}

	/**
	 * 把sourcePath文件夹复制到newPath文件夹中
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param sourcePath
	 * @param newPath
	 * @throws IOException
	 */
	public static void copyDir(String sourcePath, String newPath)
	        throws IOException {
		File file = new File(sourcePath);

		String fileSeperator = File.separator;
		String[] filePath = file.list();

		if (!(new File(newPath)).exists()) {
			(new File(newPath)).mkdir();
		}

		for (int i = 0; i < filePath.length; i++) {
			if ((new File(sourcePath + fileSeperator + filePath[i]))
			        .isDirectory()) {
				copyDir(sourcePath + fileSeperator + filePath[i],
				        newPath + fileSeperator + filePath[i]);
			}

			if (new File(sourcePath + fileSeperator + filePath[i]).isFile()) {
				copyFile(sourcePath + fileSeperator + filePath[i],
				        newPath + fileSeperator + filePath[i]);
			}

		}
	}

	/**
	 * 复制文件
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param oldPath
	 * @param newPath
	 * @throws IOException
	 */
	public static void copyFile(String oldPath, String newPath)
	        throws IOException {
		File oldFile = new File(oldPath);
		File file = new File(newPath);

		try (FileInputStream in = new FileInputStream(oldFile);
		        FileOutputStream out = new FileOutputStream(file);) {
			byte[] buffer = new byte[2097152];
			int readByte = 0;
			while ((readByte = in.read(buffer)) != -1) {
				out.write(buffer, 0, readByte);
			}
		}
	}

	/**
	 * 复制文件夹
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param sourceDir
	 * @param destDir
	 */
	public static void copyDirectory(String sourceDir, String destDir) {
		try {
			// 不存在则创建
			if (!new File(destDir).exists()) {
				FileUtils.forceMkdir(new File(destDir));
			}

			FileUtils.copyDirectory(new File(sourceDir), new File(destDir));
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("拷贝文件出错,从{},到{}", sourceDir, destDir);
		}
	}

	/**
	 * 复制文件夹
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param sourceDir:源文件
	 * @param destDir
	 */
	public static void copyDirectory(File sourceDir, File destDir) {
		try {
			// 不存在则创建
			if (!destDir.exists()) {
				FileUtils.forceMkdir(destDir);
			}

			FileUtils.copyDirectory(sourceDir, destDir);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("拷贝文件出错,从{},到{}", sourceDir.getAbsolutePath(),
			        destDir.getAbsolutePath());
		}
	}

	/**
	 * 删除文件夹
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param toDelteDir
	 */
	public static void deleteDirectory(File toDelteDir) {
		try {
			FileUtils.deleteDirectory(toDelteDir);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("删除文件夹失败:{}", toDelteDir.getAbsolutePath());
		}
	}

	/**
	 * 删除文件夹
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param toDelteDir
	 */
	public static void forceDeleteDirectory(File toDelteDir) {
		try {
			if (toDelteDir.exists()) {
				FileUtils.forceDelete(toDelteDir);
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("删除文件夹失败:{}", toDelteDir.getAbsolutePath());
		}
	}

	/**
	 * 删除文件夹
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param toDelteDir
	 */
	public static void deleteDirectory(String toDelteDir) {
		try {
			FileUtils.deleteDirectory(new File(toDelteDir));
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("删除文件夹失败:{}", toDelteDir);
		}
	}

	/**
	 * 下载文件
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param filePath
	 */
	public static void downloadFile(String filePath,
	        HttpServletResponse response) {
		response.setHeader("content-type", "application/octet-stream");
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition",
		        "attachment;filename=" + filePath);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			bis = new BufferedInputStream(
			        new FileInputStream(new File(filePath)));
			int i = bis.read(buff);
			while (i != -1) {
				os.write(buff, 0, buff.length);
				os.flush();
				i = bis.read(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 清空文件内容
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param filePath
	 */
	public static void clearFileContent(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (FileWriter fileWriter = new FileWriter(file);) {
			fileWriter.write("");
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 追加文件内容
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param fileName
	 * @param fileContent
	 * @param appendToFile
	 */

	public static void writeToFile(String fileName, String fileContent,
	        boolean appendToFile) {
		File file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (FileWriter fileWriter = new FileWriter(file, appendToFile)) {
			fileWriter.write(fileContent);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 遍历文件
	 * 
	 * @see :
	 * @param :
	 * @param topLevelFolder
	 * @return
	 */
	public static void walkFolder(File topLevelFolder) {

		if (!topLevelFolder.exists()) {
			return;
		}

		filesAndFolders.add(topLevelFolder);
		if (topLevelFolder.isDirectory()) {
			onlyFolders.add(topLevelFolder);
			File[] filesAndFoldersUnderThis = topLevelFolder.listFiles();
			for (File eachFileUnderThis : filesAndFoldersUnderThis) {
				walkFolder(eachFileUnderThis);
			}
		} else if (topLevelFolder.isFile()) {
			onlyFiles.add(topLevelFolder);
		}
	}

	/**
	 * 删除文件
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param toDeleteFile
	 */
	public static void deleteFile(File toDeleteFile) {
		if (toDeleteFile.exists()) {
			try {
				FileUtils.forceDelete(toDeleteFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see :
	 * @param :
	 * @return : File
	 * @param filePath
	 * @param inputStream
	 * @return
	 */
	public static void createFileUseInputStream(String filePath,
	        InputStream inputStream) {
		File outFile = new File(filePath);

		BufferedInputStream in = null;
		in = new BufferedInputStream(inputStream);

		try (FileOutputStream fileOutputStream = new FileOutputStream(outFile);
		        BufferedOutputStream out = new BufferedOutputStream(
		                fileOutputStream);) {
			int len = -1;
			byte[] b = new byte[1024];
			while ((len = in.read(b)) != -1) {
				out.write(b, 0, len);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 下载文件
	 * 
	 * @param response
	 * @param file
	 * @param newFileName
	 */
	public static void downloadFile(HttpServletResponse response, File file,
	        String newFileName) {
		try {
			response.setHeader("Content-Disposition", "attachment; filename="
			        + new String(newFileName.getBytes("ISO-8859-1"), "UTF-8"));
			BufferedOutputStream bos = new BufferedOutputStream(
			        response.getOutputStream());
			InputStream is = new FileInputStream(file.getAbsolutePath());
			BufferedInputStream bis = new BufferedInputStream(is);
			int length = 0;
			byte[] temp = new byte[1 * 1024 * 10];
			while ((length = bis.read(temp)) != -1) {
				bos.write(temp, 0, length);
			}
			bos.flush();
			bis.close();
			bos.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取txt文件的内容
	 * 
	 * @param file
	 *            想要读取的文件路径
	 * @return 返回文件内容
	 */
	public static String readFileCommon(String file) {
		return readFile(new File(file));
	}

	/**
	 * 读取txt文件的内容
	 * 
	 * @param file
	 *            想要读取的文件对象
	 * @return 返回文件内容
	 */
	public static String readFile(File file) {
		StringBuilder result = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
			String s = null;
			while ((s = br.readLine()) != null) {
				// 使用readLine方法，一次读一行
				result.append(System.lineSeparator() + s);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	/**
	 * 递归删除文件
	 * 
	 * @param file
	 */
	public static void deleteFileWithRecursion(File file) {
		// 判断是否是一个目录, 不是的话跳过, 直接删除; 如果是一个目录, 先将其内容清空.
		if (file.isDirectory()) {
			// 获取子文件/目录
			File[] subFiles = file.listFiles();
			// 遍历该目录
			for (File subFile : subFiles) {
				// 递归调用删除该文件: 如果这是一个空目录或文件, 一次递归就可删除.
				// 如果这是一个非空目录, 多次递归清空其内容后再删除
				deleteFile(subFile);
			}
		}
		// 删除空目录或文件
		file.delete();
	}

	/**
	 * 获取项目根路径
	 * 
	 * @return
	 */
	public static String getProjectPath() {
		String classPath = getClassPath();
		return new File(classPath).getParentFile().getParentFile()
		        .getAbsolutePath();
	}

	/**
	 * 获取类路径
	 * 
	 * @return
	 */
	public static String getClassPath() {
		String classPath = FileUtils.class.getClassLoader().getResource("")
		        .getPath();
		return classPath;
	}
}
