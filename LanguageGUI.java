package languages;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LanguageGUI extends JPanel
{
	private static final long serialVersionUID = 1L;	//
	private JComboBox<String> langBox;	//Drop-down box for language options
	private JButton calculateButton;	//Button to prompt age calculations
	private JTextField yearField, monthField, dayField;	//Text boxes to accept user inputs
	private JLabel yearLabel, monthLabel, dayLabel; //Descriptions set next to the text boxes
	private JLabel todayDisplay, birthdayDisplay, ageDisplay;	//Messages to be displayed
	private JCheckBox kanjiCheckBox, numCheckBox;	//Checkbox to show display with kanji or number format
	
	private JPanel options;	//Panel holds langbox, kanjiCheckBox, and numCheck
	private JPanel inputs;	//Holds yearField, monthField, dayField, yearLabel, monthLabel, and dayLabel
	private JPanel output1, output2, output3;	//Holds the three displays
	
	private Age me; //Age information will be stored here
	private boolean foundAge;	//Flag where to determine if age is calculated (button will create errors if you click it with empty field)
	
	public LanguageGUI()
	{
		foundAge = false;
		
		//Create the language options for drop-down box
		String [] LanguageOption =
			{"English", "Русский", "日本語"};
		
		options = new JPanel();
		inputs = new JPanel();
		output1 = new JPanel();
		output2 = new JPanel();
		output3 = new JPanel();
		
		langBox = new JComboBox<>(LanguageOption);
		langBox.setPreferredSize(new Dimension (150,30));
		langBox.setBackground(Color.white);
		langBox.setToolTipText("Language");
		langBox.addActionListener(new ComboListener());
		
		kanjiCheckBox = new JCheckBox ("漢字", true);
		kanjiCheckBox.setToolTipText("漢字かひらがなをみる");
		kanjiCheckBox.addActionListener(new KanjiCheckBoxListener());
		kanjiCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		numCheckBox = new JCheckBox ("Numerals", true);
		numCheckBox.setToolTipText("View with numbers or words");
		numCheckBox.addActionListener(new numCheckBoxListener());
		numCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		calculateButton = new JButton ("Calculate");
		calculateButton.setToolTipText("Calculate age");
		calculateButton.addActionListener(new CalculateButtonListener());
		
		yearField = new JTextField(4);
		yearField.setToolTipText("Enter the year (YYYY)");
		monthField = new JTextField(2);
		monthField.setToolTipText("Enter the month (MM)");
		dayField = new JTextField(2);
		dayField.setToolTipText("Enter the day (DD)");
		
		yearLabel = new JLabel("Year: ");
		monthLabel = new JLabel("Month: ");
		dayLabel = new JLabel("Day: ");
		
		todayDisplay = new JLabel("Welcome! This program calculates ages. \n");
		birthdayDisplay = new JLabel("Добро пожаловать! Эта программа вычисляет возраст.\n");
		ageDisplay = new JLabel("ようこそ！このプログラムは年齢を計算します。\n");
		
		kanjiCheckBox.setVisible(false);
		
		options.add(langBox);
		options.add(numCheckBox);
		options.add(kanjiCheckBox);
		
		inputs.add(monthLabel);
		inputs.add(monthField);
		inputs.add(dayLabel);
		inputs.add(dayField);
		inputs.add(yearLabel);
		inputs.add(yearField);
		inputs.add(calculateButton);
		
		output1.add(todayDisplay);
		output2.add(birthdayDisplay);
		output3.add(ageDisplay);
		
		add(options, BorderLayout.NORTH);
		add(inputs, BorderLayout.CENTER);
		add(output1, BorderLayout.SOUTH);
		add(output2, BorderLayout.SOUTH);
		add(output3, BorderLayout.SOUTH);
	}//public LanguageGUI()
	
	//Re-display new layout
	private void Refresh()
	{//The program will need to refresh its layout often
		add(options, BorderLayout.PAGE_START);
		
		//User wishes to change language to English
		if(langBox.getSelectedIndex() == 0)
		{
			langBox.setToolTipText("Language");
			numCheckBox.setText("Numerals");
			kanjiCheckBox.setVisible(false);
			calculateButton.setText("Calculate");
			calculateButton.setToolTipText("Calculate age");
			yearField.setToolTipText("Enter the year (YYYY)");
			monthField.setToolTipText("Enter the month (MM)");
			dayField.setToolTipText("Enter the day (DD)");
			yearLabel.setText("Year: ");
			monthLabel.setText("Month: ");
			dayLabel.setText("Day: ");
			
			
			inputs.add(monthLabel);
			inputs.add(monthField);
			inputs.add(dayLabel);
			inputs.add(dayField);
			inputs.add(yearLabel);
			inputs.add(yearField);
			
			if(foundAge)
			{
				if (numCheckBox.isSelected())
				{
					todayDisplay.setText(English.getTodayInNumbers(me));
					birthdayDisplay.setText(English.getBirthdayInNumbers(me));
					ageDisplay.setText(English.getAgeInNumbers(me));
				}
	
				else
				{
					todayDisplay.setText(English.getTodayInWords( me));
					birthdayDisplay.setText(English.getBirthdayInWords( me));
					ageDisplay.setText(English.getAgeInWords(me));
				}
			}
			
		}//end if statement for English
		
		//User wishes to change language to Russian
		if(langBox.getSelectedIndex() == 1)
		{
			langBox.setToolTipText("Язык");
			numCheckBox.setText("Цифры");
			kanjiCheckBox.setVisible(false);
			//TODO Correctly find terms for text and tiptext
			calculateButton.setText("Подcчитать");
			calculateButton.setToolTipText("Рассчитать возраст");
			numCheckBox.setToolTipText("Просмотр с цифрами или словами");
			yearField.setToolTipText("Введите год (YYYY)");
			monthField.setToolTipText("Введите месяц (MM)");
			dayField.setToolTipText("Введите день (DD)");
			yearLabel.setText("Год: ");
			monthLabel.setText("Месяц: ");
			dayLabel.setText("День: ");
			
			kanjiCheckBox.setVisible(false);
			
			inputs.add(dayLabel);
			inputs.add(dayField);
			inputs.add(monthLabel);
			inputs.add(monthField);
			inputs.add(yearLabel);
			inputs.add(yearField);
			
			if(foundAge)
			{
				if (numCheckBox.isSelected())
				{
					todayDisplay.setText(Russian.getTodayInNumbers(me));
					birthdayDisplay.setText(Russian.getBirthdayInNumbers(me));
					ageDisplay.setText(Russian.getAgeInNumbers(me));
				}
	
				else
				{
					todayDisplay.setText(Russian.getTodayInWords( me));
					birthdayDisplay.setText(Russian.getBirthdayInWords( me));
					ageDisplay.setText(Russian.getAgeInWords(me));
				}
			}//end if statement 
			
		}//end if statement for Russian
		
		//User wishes to change language to Japanese (Kanji)
		if(langBox.getSelectedIndex() == 2 && kanjiCheckBox.isSelected())
		{
			kanjiCheckBox.setVisible(true);
			langBox.setToolTipText("言語");
			numCheckBox.setText("数字");
			//TODO Find correct terms for the following
			calculateButton.setText("計算する");
			calculateButton.setToolTipText("年齢を計算する");
			numCheckBox.setToolTipText("数字でみる");
			yearField.setToolTipText("年を入力してください (YYYY)");
			monthField.setToolTipText("月を入力してください (MM)");
			dayField.setToolTipText("日を入力してください (DD)");
			yearLabel.setText("年");
			monthLabel.setText("月");
			dayLabel.setText("日");
			
			inputs.add(yearField);
			inputs.add(yearLabel);
			inputs.add(monthField);
			inputs.add(monthLabel);
			inputs.add(dayField);
			inputs.add(dayLabel);
			
			if(foundAge)
			{
				if (numCheckBox.isSelected())
				{
					todayDisplay.setText(Kanji.getTodayInNumbers(me));
					birthdayDisplay.setText(Kanji.getBirthdayInNumbers(me));
					ageDisplay.setText(Kanji.getAgeInNumbers(me));
				}
	
				else
				{
					todayDisplay.setText(Kanji.getTodayInWords( me));
					birthdayDisplay.setText(Kanji.getBirthdayInWords( me));
					ageDisplay.setText(Kanji.getAgeInWords(me));
				}
			}//end if statement for Japanese (Kanji)
			
		}//end if statement for Japanese (Kanji)
		
		//User wishes to change language to Japanese (Kana)
		if(langBox.getSelectedIndex() == 2 && !kanjiCheckBox.isSelected())
		{
			
			langBox.setToolTipText("げんご");
			numCheckBox.setText("すうじ");
			kanjiCheckBox.setVisible(true);
			//TODO Find correct terms for the following
			calculateButton.setText("けいさんする");
			calculateButton.setToolTipText("ねんれいをけいさんする");
			numCheckBox.setToolTipText("すうじでみる");
			yearField.setToolTipText("としをにゅうりょくしてください (YYYY)");
			monthField.setToolTipText("月をにゅうりょくしてください (MM)");
			dayField.setToolTipText("日をにゅうりょくしてください (DD)");
			yearLabel.setText("ねん");
			monthLabel.setText("がつ");
			dayLabel.setText("にち");
			
			inputs.add(yearField);
			inputs.add(yearLabel);
			inputs.add(monthField);
			inputs.add(monthLabel);
			inputs.add(dayField);
			inputs.add(dayLabel);

			//Changes welcome text if the age has been calculated
			if(foundAge)
			{
				if (numCheckBox.isSelected())
				{
					todayDisplay.setText(Hiragana.getTodayInNumbers(me));
					birthdayDisplay.setText(Hiragana.getBirthdayInNumbers(me));
					ageDisplay.setText(Hiragana.getAgeInNumbers(me));
				}
	
				else
				{
					todayDisplay.setText(Hiragana.getTodayInWords( me));
					birthdayDisplay.setText(Hiragana.getBirthdayInWords( me));
					ageDisplay.setText(Hiragana.getAgeInWords(me));
				}
			}//end if statement for Japanese (Kana)
		}//end if statement for Japanese (Kana)
		
		//Display lower portion of pane
		inputs.add(calculateButton);
		add(inputs, BorderLayout.CENTER);
		add(output1, BorderLayout.SOUTH);
		add(output2, BorderLayout.SOUTH);
		add(output3, BorderLayout.SOUTH);
	}//end function private void Refresh()
	
	//Implement the drop-down box that selects language option
	private class ComboListener implements ActionListener
	{
		@Override
		public void actionPerformed (ActionEvent event)
		{
			Refresh();
		}//end public void actionPerformed (ActionEvent event)
	}//end private class ComboListener
	
	//Implement the check box that displays if sentences display numerals or words
	private class numCheckBoxListener implements ActionListener
	{
		@Override
		public void actionPerformed (ActionEvent event)
		{
			Refresh();
		}
	}//end private class numCheckBoxListener implements ActionListener

	//Implement the check box that displays Japanese in kanji or kana
	private class KanjiCheckBoxListener implements ActionListener
	{
		@Override
		public void actionPerformed (ActionEvent event)
		{
			Refresh();
		}//end public void actionPerformed (ActionEvent event)
	}//end private class LanguageChangeButtonListener
	
	//Implement the button that calculates the age
	private class CalculateButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed (ActionEvent event)
		{
			int yearT, monthT, dayT; //Data collected from textbox
			
			try
			{
			yearT = Integer.parseInt(yearField.getText());
			monthT = Integer.parseInt(monthField.getText());
			dayT = Integer.parseInt(dayField.getText());
			
			me = new Age( dayT, monthT, yearT );
			}
			
			catch (NumberFormatException e) 
			{
				todayDisplay.setText("There was an error.\n");
				birthdayDisplay.setText("Произошла ошибка.\n");
				ageDisplay.setText("エラーがありました。");
			}
			catch (NullPointerException f)
			{
				todayDisplay.setText("There was an error.\n");
				birthdayDisplay.setText("Произошла ошибка.\n");
				ageDisplay.setText("エラーがありました。");
			}
			catch (IllegalArgumentException e)
			{
				todayDisplay.setText("Out of bounds\n");
				birthdayDisplay.setText("of\n");
				ageDisplay.setText("BOUNDS");
			}

			//User wishes to change language to English
			if(langBox.getSelectedIndex() == 0)
			{
				if (numCheckBox.isSelected())
				{
					todayDisplay.setText(English.getTodayInNumbers(me));
					birthdayDisplay.setText(English.getBirthdayInNumbers(me));
					ageDisplay.setText(English.getAgeInNumbers(me));
				}
	
				else
				{
					todayDisplay.setText(English.getTodayInWords( me));
					birthdayDisplay.setText(English.getBirthdayInWords( me));
					ageDisplay.setText(English.getAgeInWords(me));
				}
			}//end if statement for English
	
			//User wishes to change language to Russian
			if(langBox.getSelectedIndex() == 1)
			{
				if (numCheckBox.isSelected())
				{
					todayDisplay.setText(Russian.getTodayInNumbers(me));
					birthdayDisplay.setText(Russian.getBirthdayInNumbers(me));
					ageDisplay.setText(Russian.getAgeInNumbers(me));
				}
	
				else
				{
					todayDisplay.setText(Russian.getTodayInWords( me));
					birthdayDisplay.setText(Russian.getBirthdayInWords( me));
					ageDisplay.setText(Russian.getAgeInWords(me));
				}
			}//end if statement for Russian
	
			//User wishes to change language to Japanese (Kanji)
			if(langBox.getSelectedIndex() == 2 && kanjiCheckBox.isSelected())
			{
				if (numCheckBox.isSelected())
				{
					todayDisplay.setText(Kanji.getTodayInNumbers(me));
					birthdayDisplay.setText(Kanji.getBirthdayInNumbers(me));
					ageDisplay.setText(Kanji.getAgeInNumbers(me));
				}
	
				else
				{
					todayDisplay.setText(Kanji.getTodayInWords( me));
					birthdayDisplay.setText(Kanji.getBirthdayInWords( me));
					ageDisplay.setText(Kanji.getAgeInWords(me));
				}
			}//end if statement for Japanese (Kanji)
	
			//User wishes to change language to Japanese (Kana)
			if(langBox.getSelectedIndex() == 2 && !kanjiCheckBox.isSelected())
			{
				if (numCheckBox.isSelected())
				{
					todayDisplay.setText(Hiragana.getTodayInNumbers(me));
					birthdayDisplay.setText(Hiragana.getBirthdayInNumbers(me));
					ageDisplay.setText(Hiragana.getAgeInNumbers(me));
				}
	
				else
				{
					todayDisplay.setText(Hiragana.getTodayInWords( me));
					birthdayDisplay.setText(Hiragana.getBirthdayInWords( me));
					ageDisplay.setText(Hiragana.getAgeInWords(me));
				}
			}//end if statement for Japanese (Kana)
			foundAge = true;
		}//public void actionPerformed (ActionEvent event)
		
	}//end private class ButtonListener
	
}//end public class GUI extends JPanel