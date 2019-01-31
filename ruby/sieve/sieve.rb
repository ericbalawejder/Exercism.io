require 'prime'

# Sieve cheating with ruby.
class Sieve
  def initialize(number)
    self.number = number
  end

  def primes
    Prime.each(number).to_a
  end

  private

  attr_accessor :number
end
