package com.lansmancai.lantetris.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import com.lansmancai.lantetris.exception.GameException;
import com.lansmancai.lantetris.object.Piece;
import com.lansmancai.lantetris.object.Square;

public class ImageUtil {

	
	public static BufferedImage getImage(String imagePath) {
    	try {
    		//ʹ��ImageIO��ȡͼƬ
    		return ImageIO.read(new File(imagePath));
    	} catch (IOException e) {
    		//��ȡͼƬ�����쳣���׳�GameException
    		throw new GameException("read image error");
    	}
	}
	
	/**
	 * �ڽ����ϻ�һ��Piece����
	 * @param g
	 * @param piece
	 */
	public static void paintPiece(Graphics g, Piece piece) {
		if (piece == null) return;
		for (int i = 0; i < piece.getSquares().size(); i++) {
			Square s = piece.getSquares().get(i);
			g.drawImage(s.getImage(), s.getBeginX(), s.getBeginY(), null);
		}
	}
}