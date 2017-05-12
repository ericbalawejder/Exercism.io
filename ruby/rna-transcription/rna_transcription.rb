class Complement
  COMPLEMENTS = {
    'G' => 'C',
    'C' => 'G',
    'T' => 'A',
    'A' => 'U'
  }.freeze

  def self.of_dna(strand)
    # Logic for checking bad input?? Complement_of_zero_or_more("GCTA") in the alphabet?
    raise ArgumentError, "Bad input strands" if !strand.include?("G" || "C") 
    strand.chars.map {|nucleotide| COMPLEMENTS.fetch(nucleotide)}.join
  end
end

module BookKeeping
  # Where the version number matches the one in the test.
  VERSION = 4 
end