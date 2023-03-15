package com.lansmancai.lantetris.object.impl;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.lansmancai.lantetris.object.Piece;
import com.lansmancai.lantetris.object.PieceCreator;
import com.lansmancai.lantetris.object.Square;
import com.lansmancai.lantetris.piece.Piece0;
import com.lansmancai.lantetris.piece.Piece1;
import com.lansmancai.lantetris.piece.Piece2;
import com.lansmancai.lantetris.piece.Piece3;
import com.lansmancai.lantetris.piece.Piece4;
import com.lansmancai.lantetris.piece.Piece5;
import com.lansmancai.lantetris.piece.Piece6;
import com.lansmancai.lantetris.util.ImageUtil;

public class PieceCreatorImpl implements PieceCreator {

	//�������Square
	private Map<Integer, Image> images = new HashMap<Integer, Image>();
	
	//�ܹ���������ɫ�ķ���
	private final static int COLOR_SIZE = 7;
	
	//�ܹ������ִ󷽿�
	private final static int SQUARE_SIZE = 7;
	
	private Random random = new Random();
		
	@Override
	public Piece createPiece(int x, int y) {
		//����õ�һ�ŷ���ͼƬ
		Image image = getImage(random.nextInt(COLOR_SIZE));
		Piece piece = initPiece(image);
		piece.setSquaresXLocation(x);
		piece.setSquaresYLocation(y);
		return piece;
	} 
	
	private Piece initPiece(Image image) {
		Piece piece = null;
		int pieceType = random.nextInt(SQUARE_SIZE);
		//��ʼ��Piece��������������󷽿�
		if (pieceType == 0) {
			piece = new Piece0(image);
		} else if (pieceType == 1) {
			piece = new Piece1(image);
		} else if (pieceType == 2) {
			piece = new Piece2(image);
		} else if (pieceType == 3) {
			piece = new Piece3(image);
		} else if (pieceType == 4) {
			piece = new Piece4(image);
		} else if (pieceType == 5) {
			piece = new Piece5(image);
		} else if (pieceType == 6) {
			piece = new Piece6(image);
		}
//		piece = new Piece1(image);
		return piece;
	}
	
	/**
	 * ��map�еõ�ͼƬ�������map��û�д���ͼƬ����, �򴴽�
	 * @param key
	 * @return
	 */
	private Image getImage(int key) {
		if (this.images.get(key) == null) {
			Image s = ImageUtil.getImage("images/square" + key + ".jpg");
			this.images.put(key, s);
		}
		return this.images.get(key);
	}

	@Override
	public Piece getPiece() {
		// TODO Auto-generated method stub
		return null;
	}

}
