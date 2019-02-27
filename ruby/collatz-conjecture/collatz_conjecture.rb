module CollatzConjecture
  def self.steps(number)
    raise ArgumentError if number <= 0

    step = 0
    while number > 1
      number = number.even? ? number / 2 : 3 * number + 1
      step += 1
    end
    step
  end
end
