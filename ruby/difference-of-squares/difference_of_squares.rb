# Find the difference between the square of the sum and
# the sum of the squares of the first N natural numbers.
class Squares
  def initialize(natural_number)
    @n = natural_number
  end

  def sum_of_squares
    (n * (n + 1) * (2 * n + 1)) / 6
  end

  def square_of_sum
    ((n * (n + 1)) / 2)**2
  end

  def difference
    square_of_sum - sum_of_squares
  end

  private

  attr_reader :n
end

module BookKeeping
  # Where the version number matches the one in the test.
  VERSION = 4
end
