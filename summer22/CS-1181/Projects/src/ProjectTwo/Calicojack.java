package ProjectTwo;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Calicojack {

    JFrame frame = new JFrame();
    JPanel startPanel = new JPanel();
    JButton begin = new JButton("Begin");
    JButton directionsButton = new JButton("Directions");
    JPanel directionsPanel = new JPanel();
    JButton back = new JButton("Back");
    JPanel table = new JPanel();
    ArrayList<Card> dealerCards = new ArrayList<>();
    ArrayList<Card> playerCards = new ArrayList<>();
    ArrayList<Integer> dealerValues = new ArrayList<>();
    ArrayList<Integer> playerValues = new ArrayList<>();
    JButton hit = new JButton("Hit");
    JButton stand = new JButton("Stand");
    JLabel totalPointsLabel = new JLabel();
    JLabel dealerValueLabel = new JLabel();
    JLabel playerValueLabel = new JLabel();
    JLabel pointsBetLabel = new JLabel();
    CardLayout cL = new CardLayout();
    JPanel cardPanel = new JPanel();
    JTextArea directions = new JTextArea();
    JLabel backOfCard = new JLabel();
    JPanel loseScreen = new JPanel();
    JPanel winScreen = new JPanel();
    JPanel thanks = new JPanel();
    JButton newGame = new JButton("New Game");
    JButton quit = new JButton("Quit");
    Icon cardImage = new ImageIcon();    
    JLabel youLose = new JLabel("You Lose");
    JLabel dealerCloser = new JLabel("Dealer's closer to 21");
    JLabel youBust = new JLabel("Bust!");
    JLabel result = new JLabel("Result: -100");
    JLabel loserTotalPoints = new JLabel();
    int clicks = 0;
    int totalPoints = 500;
    int pointsBet = 100;
    int dealerValue = 0;
    int playerValue = 0;
    int count = 0;
    Timer timer;
    int seconds = 0;

    Calicojack() throws InterruptedException, IOException {

        frame.setTitle("Calicojack");
        frame.setSize(1100, 900);
        frame.setResizable(false);

        cardPanel.setLayout(cL);
        cardPanel.add(startPanel, "1");
        cardPanel.add(table, "2");
        cardPanel.add(directionsPanel, "3");
        cardPanel.add(loseScreen, "4");
        cardPanel.add(winScreen, "5");
        cardPanel.add(thanks, "6");

        startPanel.setBackground(new Color(0, 128, 0));
        startPanel.setLayout(null);

        begin.setFont(new Font("Consolas", Font.PLAIN, 25));
        begin.setFocusable(false);
        begin.setBackground(new Color(254, 210, 131));
        begin.setBorder(BorderFactory.createLineBorder(Color.black));
        begin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cL.show(cardPanel, "2");
            }
        });
        
        directionsButton.setFont(new Font("Consolas", Font.PLAIN, 25));
        directionsButton.setFocusable(false);
        directionsButton.setBackground(new Color(254, 210, 131));
        directionsButton.setBorder(BorderFactory.createLineBorder(Color.black));
        directionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cL.show(cardPanel, "3");
            }
        });

        begin.setBounds(450, 275, 200, 100);
        directionsButton.setBounds(400, 425, 300, 100);

        startPanel.add(begin);
        startPanel.add(directionsButton);


        directionsPanel.setBackground(new Color(0, 128, 0));
        directionsPanel.setLayout(null);

        directions.setText("Calicojack is a take on the classic card game Blackjack. \n\nThis version originates from the video game Stardew Valley.\n\nSimilar rules apply, where the objective is to score as high as you can without exceeding 21.\n\nIt will be the player against the dealer.\n\nThe player and dealer will both be dealt two cards, with values 1-11. The following dealt cards will also be 1-11.\n\nHowever, the player will only be able to see one of the dealer's two cards.\n\nThe player may choose to “hit”, which is to draw another card, until they “stand” or “bust”.\n\nTo “stand” is to stick with the cards you have, to “bust” is to go over 21, resulting in a loss for the player.\n\nAfter standing, the dealer’s second card will be shown, and will be dealt more cards.\n\nThe dealer’s cards will keep being dealt until their total value is either higher than the player’s or over 21.\n\nIf the player has a higher valid score, they win.\n\nThe player will start with 500 points. They will bet 100 on the first game.\n\nIf the player loses, they lose the 100 points that they bet.\n\nIf the player wins, they can choose to take the 100 points and bet another 100 or decide to bet double or nothing.\n\nChoosing double or nothing will not award you the points that were won, and doubles it, meaning if you win the next one you will receive double the points. You can continue to choose double or nothing after each consecutive win.\n\nHowever, that also means that if you lose, you will lose double the points.\n\nReach 2000 points, and you beat the game. Have fun!");
        directions.setFont(new Font("Consolas", Font.BOLD, 16));
        directions.setLineWrap(true);
        directions.setWrapStyleWord(true);
        directions.setEditable(false);
        directions.setBounds(17, 175, 1050, 850);
        directions.setBackground(new Color(0, 128, 0));
        directionsPanel.add(directions);

        back.setBounds(25, 50, 100, 50);
        back.setFont(new Font("Consolas", Font.PLAIN, 16));
        back.setFocusable(false);
        back.setBackground(new Color(254, 210, 131));
        back.setBorder(BorderFactory.createLineBorder(Color.black));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cL.show(cardPanel, "1");
            }
        });
        directionsPanel.add(back);
    	
        int halfDeckSize = 26;
        for (int i = 0; i < halfDeckSize; i++) {
            dealerCards.add(getCard());
            
        }

        for (int i = 0; i < halfDeckSize; i++) {
            playerCards.add(getCard());
        }

        table.setBackground(new Color(0, 128, 0));
        table.setLayout(null);

        hit.setBounds(900, 375, 80, 50);
        hit.setFont(new Font("Consolas", Font.PLAIN, 20));
        hit.setBackground(new Color(254, 210, 131));
        hit.setBorder(BorderFactory.createLineBorder(Color.black));
        hit.setFocusable(false);

        stand.setBounds(860, 450, 120, 50);
        stand.setFont(new Font("Consolas", Font.PLAIN, 20));
        stand.setBackground(new Color(254, 210, 131));
        stand.setBorder(BorderFactory.createLineBorder(Color.black));
        stand.setFocusable(false);
        
        totalPointsLabel.setBounds(830, 70, 150, 100);
        totalPointsLabel.setText(String.valueOf(totalPoints));
        labelDetails(totalPointsLabel, 35);
        
        Icon cardBack = new ImageIcon("projects/src/images/cardback.png");
        backOfCard.setIcon(cardBack);
        backOfCard.setBounds(80, 150, 100, 150);
        
        dealerValueLabel.setBounds(70, 60, 280, 50);
        dealerValueLabel.setText("Dealer: ?");
        labelDetails(dealerValueLabel, 30);
        
        playerValueLabel.setBounds(70, 735, 280, 50);
        playerValueLabel.setText("Player: " + playerCards.get(0).value);
        labelDetails(playerValueLabel, 30);
        
        pointsBetLabel.setBounds(70, 400, 280, 50);
        pointsBetLabel.setText("Bet: " + String.valueOf(pointsBet));
        labelDetails(pointsBetLabel, 30);
        
        int x = 80;        
        for (int i = 0; i < dealerCards.size(); i++) {
        	dealerCards.get(i).label.setBounds(x, 150, 100, 150);
        	x += 105;
        }
        
        int y = 80;        
        for (int i = 0; i < playerCards.size(); i++) {
        	playerCards.get(i).label.setBounds(y, 550, 100, 150);
        	y += 105;
        }
        
        hit.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {		
        		clicks++;
        		playerValues.add(playerCards.get(clicks).value);
        		table.add(playerCards.get(clicks).label);
        		table.revalidate();
        		table.repaint();   
        		playerValueLabel.setText("Player: " + (getPlayerValue()));
        		if (getPlayerValue() > 21) {
        			cL.show(cardPanel,  "4");
                	loseScreen.add(youBust);
        		}
        	}
        });

        ActionListener standTimer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                seconds++;
                if (seconds == 1) {
                    table.remove(backOfCard);
                    table.revalidate();
                    table.repaint();        		
                    backOfCard = dealerCards.get(0).label;
                    backOfCard.setBounds(80, 150, 100, 150);
                    table.add(backOfCard);
                    table.revalidate();
                    table.repaint();                 
                }  
                if (seconds >= 2) {
                    table.add(dealerCards.get(seconds).label);   
                    dealerValues.add(dealerCards.get(seconds).value);
                    table.revalidate();
                    table.repaint();             
                } 
                dealerValueLabel.setText("Dealer: " + (getDealerValue() + dealerCards.get(0).value));  
                if ((getDealerValue() + dealerCards.get(0).value) >= 21) {
                    try {
                        timer.stop();  
                        table.add(dealerCards.get(seconds).label);
                        dealerValues.add(dealerCards.get(seconds).value);
                        table.revalidate();
                        table.repaint();                                               
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    cL.show(cardPanel, "5");
                } else if ((getDealerValue() + dealerCards.get(0).value) > getPlayerValue() && (getDealerValue() + dealerCards.get(0).value) <= 21) {
                    try {
                        timer.stop();   
                        table.add(dealerCards.get(seconds).label);
                        dealerValues.add(dealerCards.get(seconds).value);
                        table.revalidate();
                        table.repaint();                           
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }

                    cL.show(cardPanel, "4");
                }
            }
        };

        timer = new Timer(1000, standTimer);
        stand.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		hit.setEnabled(false);
        		stand.setEnabled(false);   
                timer.start();
        	}
        });

        table.add(pointsBetLabel);
        table.add(playerValueLabel);
        table.add(dealerValueLabel);
        table.add(backOfCard);
        table.add(totalPointsLabel);
        table.add(stand);
        table.add(hit);
        table.add(dealerCards.get(1).label);
        table.add(playerCards.get(0).label);
        
        dealerCloser.setBounds(380, 100, 310, 45);
        labelDetails(dealerCloser, 22);
        
        youLose.setBounds(450, 165, 175, 45);
        labelDetails(youLose, 22);
        
        youBust.setBounds(450, 100, 175, 45);
        labelDetails(youBust, 22);
        
        loserTotalPoints.setBounds(830, 70, 150, 100);
        loserTotalPoints.setText(String.valueOf(totalPoints));
        labelDetails(loserTotalPoints, 35);
        
        result.setBounds(425, 300, 225, 45);
        labelDetails(result, 22);
        
        loseScreen.add(result);
        loseScreen.setBackground(new Color(0, 128, 0));
        loseScreen.setLayout(null);
        loseScreen.add(loserTotalPoints);
        loseScreen.add(youLose);
        
        winScreen.setBackground(new Color(0, 128, 0));
        winScreen.setLayout(null);
        
        frame.add(cardPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
   
    public int getPlayerValue() {
    	int total = playerCards.get(0).value;
    	for (int card : playerValues) {
    		total += card;
    	}
    	
    	return total;
    }
    
    public int getDealerValue() {
    	int total = dealerCards.get(1).value;
    	for (int card : dealerValues) {
    		total += card;
    	}
    	
    	return total;
    }
    
    
    public static void labelDetails(JLabel label, int x) {
        label.setBackground(new Color(254, 210, 131));
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("Consolas", Font.PLAIN, x));
    }

    public static Icon getImageIcon(int cardValue, Icon cardImage) {
        if (cardValue == 1) {
            cardImage = new ImageIcon("projects/src/images/card1.png");
        } else if (cardValue == 2) {
            cardImage = new ImageIcon("projects/src/images/card2.png");
        } else if (cardValue == 3) {
            cardImage = new ImageIcon("projects/src/images/card3.png");
        } else if (cardValue == 4) {
            cardImage = new ImageIcon("projects/src/images/card4.png");
        } else if (cardValue == 5) {
            cardImage = new ImageIcon("projects/src/images/card5.png");
        } else if (cardValue == 6) {
            cardImage = new ImageIcon("projects/src/images/card6.png");
        } else if (cardValue == 7) {
            cardImage = new ImageIcon("projects/src/images/card7.png");
        } else if (cardValue == 8) {
            cardImage = new ImageIcon("projects/src/images/card8.png");
        } else if (cardValue == 9) {
            cardImage = new ImageIcon("projects/src/images/card9.png");
        } else if (cardValue == 10) {
            cardImage = new ImageIcon("projects/src/images/card10.png");
        } else if (cardValue == 11) {
            cardImage = new ImageIcon("projects/src/images/card11.png");
        }

        return cardImage;
    }

    public static Card getCard() {
        int cardValue = getCardNum();
        Icon cardImage = new ImageIcon();
        cardImage = getImageIcon(cardValue, cardImage);
        Card card = new Card(cardValue, cardImage, new JLabel());
        card.label.setIcon(cardImage);

        return card;
    }

    public static int getCardNum() {

        int[] deck = new int[52];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = (int) ((Math.random() * 11) + 1);
        }

        int cardValue = deck[new Random().nextInt(deck.length)];

        return cardValue;
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        
        new Calicojack();
    }
}
