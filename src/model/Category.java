package model;

public enum Category {
	ACES("Aces") {
		@Override
		public int evaluateSet(int[] dice) {
			return add(this.bubbleSortDice(dice), 1);
		}
	},
	TWOS("Twos") {
		@Override
		public int evaluateSet(int[] dice) {
			return add(this.bubbleSortDice(dice), 2);
		}
	},
	THREES("Threes") {
		@Override
		public int evaluateSet(int[] dice) {
			return add(this.bubbleSortDice(dice), 3);
		}
	},
	FOURS("Fours") {
		@Override
		public int evaluateSet(int[] dice) {
			return add(this.bubbleSortDice(dice), 4);
		}
	},
	FIVES("Fives") {
		@Override
		public int evaluateSet(int[] dice) {
			return add(this.bubbleSortDice(dice), 5);
		}
	},
	SIXES("Sixes") {
		@Override
		public int evaluateSet(int[] dice) {
			return add(this.bubbleSortDice(dice), 6);
		}
	},
	THREE_OF_A_KIND("Three of a kind") {
		@Override
		public int evaluateSet(int[] dice) {
			dice = this.bubbleSortDice(dice);
			for (int i = dice.length - 1; i > 1; i--) {
                if (dice[i] == dice[i-2]){
                	/*int sumOtherDice = 0;
                	for (int j = 0; j < dice.length; j++) {
                		if (dice[j] != dice[i]) {
                			sumOtherDice += dice[j];
                		}
                	}
                	return sumOtherDice + (dice[i] * 3);*/
                	return this.sum(dice);
                } 
            }
            return 0;
		}
	},
	FOUR_OF_A_KIND("Four of a kind") {
		@Override
		public int evaluateSet(int[] dice) {
			dice = this.bubbleSortDice(dice);
			for (int i = dice.length - 1; i > 2; i--) {
                if (dice[i] == dice[i-3]){
                	/*int sumOtherDice = 0;
                	for (int j = 0; j < dice.length; j++) {
                		if (dice[j] != dice[i]) {
                			sumOtherDice += dice[j];
                		}
                	}
                	return sumOtherDice + (dice[i] * 4);*/
                	return this.sum(dice);
                } 
            }
            return 0;
		}
	},
	FULL_HOUSE("Full house") {
		@Override
		public int evaluateSet(int[] dice) {
			dice = this.bubbleSortDice(dice);
			if (dice[2] == dice[dice.length-1]) {
				if (dice[0] == dice[1]
						&& dice[0] != dice[2])
					return 25;
			}
			else if (dice[3] == dice[dice.length-1]) {
				if (dice[0] == dice[2]
						&& dice[0] != dice[3])
					return 25;
			}
			return 0;
		}
	},
	SMALL_STRAIGHT("Small straight") {
		@Override
		public int evaluateSet(int[] dice) {
			dice = this.bubbleSortDice(dice);
			int[] values = {1, 2, 3, 4};
			if (find(dice, values)) return 30;
			values = new int[]{2, 3 , 4, 5};
			if (find(dice, values)) return 30;
			values = new int[]{3 , 4, 5, 6};
			if (find(dice, values)) return 30;
			
			return 0;
		}
	},
	LARGE_STRAIGHT("Large straight") {
		@Override
		public int evaluateSet(int[] dice) {
			dice = this.bubbleSortDice(dice);
			int[] values = {1, 2, 3, 4, 5};
			if (find(dice, values)) return 40;
			values = new int[]{2, 3, 4, 5, 6};
			if (find(dice, values)) return 40;
			
			return 0;
		}
	},
	CHANCE("Chance") {
		@Override
		public int evaluateSet(int[] dice) {
			return this.sum(dice);
		}
	},
	YAHTZEE("Yahtzee") {
		@Override
		public int evaluateSet(int[] dice) {
			dice = this.bubbleSortDice(dice);
			if (dice[0] == dice[dice.length-1]) return 50;
			
			return 0;
		}
	};
	
	private final String name;
	
	Category(String name) {
		this.name = name;
	}
	
	public abstract int evaluateSet(int[] dice);
	
	public int add(int[] dice, int diceResult) {
		int sum = 0;
		
		for (int value: dice) {
			if (value == diceResult) {
				sum += value;
			}
		}
		
		return sum;
	}
	
	public int sum(int[] dice) {
		int sum = 0;
		for(int value: dice) {
			sum += value;
		}
		return sum;
	}
	
	public boolean find(int[] dice, int[] values) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < dice.length; j++) {
				if (dice[j] == values[i]) {
					values[i] = 0;
				}
			}
		}
		for (int i = 0; i < values.length; i++) {
			if (values[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	public String getName() {
		return name;
	}
	
	public Category[] getAllCategoryNames() {
		return Category.values();
	}
	
	public int[] bubbleSortDice(int[] dice) {
        boolean swapped = true;
        int i, j = dice.length;
        int tmp;
        while(swapped){
            swapped = false;
            i = 0;
            while(i < j - 1){
                if(dice[i] > dice[i+1]){
                    tmp = dice[i+1];
                    dice[i+1] = dice[i];
                    dice[i] = tmp;
                    swapped = true;
                }
                i++;
            }
            j--;
        }
        return dice;
    }
}