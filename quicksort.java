//Quicksort practice
public static void main(String[] args)
	{
		quicksort(args, args.length);

		for (int i = 0; i < args.length; i++)
		{
			System.out.print(args[i]);
			System.out.print(' ');
		}
		System.out.println();
	}

	public static void quicksort(String[] vals, int count)
	{
		// we are sorting 0 through count, inclusive at both ends.
		if (count <= 1)
		{
			// there are 1 or less element to sort, so we do nothing.
			return;
		}
		// there are 2 or more elements to sort, so we get to work.
		// 1) pick a pivot
		String pivot = vals[0];
		// 2) create left and right sublists
		String[] left = new String[count];
		String[] right = new String[count];
		// 3) elements less than or equal to the pivot go into the left
		// otherwise they go into the right

		int index = 1;
		int leftCount = 0;
		int rightCount = 0;
		while (index < count)
		{
			if (vals[index].compareTo(pivot) <= 0)
			{
				left[leftCount] = vals[index];
				leftCount++;
			} else
			{
				right[rightCount] = vals[index];
				rightCount++;
			}
			index++;
		}
		// 4)quick sort the sublists
		quicksort(left, leftCount);
		quicksort(right, rightCount);

		// 5 join the left, pivot, and right back together
		for (int i = 0; i < count; i++)
		{
			if (i < leftCount)
			{
				vals[i] = left[i];
			} else if (i == leftCount)
			{
				vals[i] = pivot;
			} else
			{
				vals[i] = right[i - (leftCount + 1)];
			}
		}

	}
}