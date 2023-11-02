package nl.delphinity.qr_goats.domain;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCode {

	private Integer genereerTijd;
	private BufferedImage afbeelding;

	public static BufferedImage generateQR(String studentData) {
		try {
			// Initialize parameters
			Map<EncodeHintType, Object> hints = new HashMap<>();
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
			hints.put(EncodeHintType.MARGIN, 2);

			// Creating the BitMatrix to save the world
			BitMatrix bitMatrix = new MultiFormatWriter().encode(studentData, BarcodeFormat.QR_CODE, 300, 300, hints);

			// Creating a BufferedImage from the BitMatrix
			BufferedImage bufferedImage = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
			for (int x = 0; x < 300; x++) {
				for (int y = 0; y < 300; y++) {
					bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? 0x000000 : 0xFFFFFF);
				}
			}

				// Returning the generated BufferedImage
				return bufferedImage;
			} catch (Exception e) {
				e.printStackTrace();
		}
		return null; // Returning null in case of an exception
	}
	
	public boolean isOptijd(LocalDateTime incheckTijd) {

		LocalDateTime now = LocalDateTime.now();

		LocalDateTime ochtendTijd = LocalDateTime.of(now.toLocalDate(), LocalTime.of(8, 31));
		LocalDateTime pauzeBegint = LocalDateTime.of(now.toLocalDate(), LocalTime.of(12, 5));
		LocalDateTime pauzeEindigt = LocalDateTime.of(now.toLocalDate(), LocalTime.of(12, 36));
		LocalDateTime eindeScalda = LocalDateTime.of(now.toLocalDate(), LocalTime.of(14, 14));

		if (incheckTijd.isBefore(ochtendTijd)) {
			return true;
		} else if (incheckTijd.isBefore(pauzeEindigt) && incheckTijd.isAfter(pauzeBegint)) {
			return true;
		} else {
			return incheckTijd.isAfter(eindeScalda);
		}
	}

	public int getGenereerTijd() {
		return genereerTijd;
	}

	public void setGenereerTijd(int genereerTijd) {
		this.genereerTijd = genereerTijd;
	}

	public BufferedImage getAfbeelding() {
		return afbeelding;
	}

	public void setAfbeelding(BufferedImage afbeelding) {
		this.afbeelding = afbeelding;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;

		result = prime * result + (genereerTijd == null ? 0 : genereerTijd.hashCode());
		result = prime * result + (afbeelding == null ? 0 : afbeelding.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		QRCode other = (QRCode) obj;

		return Objects.equals(genereerTijd, other.genereerTijd) && Objects.equals(afbeelding, other.afbeelding);
	}

	@Override
	public String toString() {
		return "QRCode [genereertijd=" + genereerTijd + ", qrafbeelding=" + afbeelding + "]";
	}
}