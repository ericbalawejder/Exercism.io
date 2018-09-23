# Given a DNA strand, return its RNA complement (per RNA transcription).
class Complement
  COMPLEMENTS = { 'G' => 'C',
                  'C' => 'G',
                  'T' => 'A',
                  'A' => 'U' }.freeze
  private_constant :COMPLEMENTS

  def self.of_dna(strand)
    strand.chars.each_with_object('') do |nucleotide, rna|
      rna << complement(nucleotide)
      break '' if rna.chars.last == '*'
    end
  end

  def self.complement(nucleotide)
    complements.fetch(nucleotide, '*')
  end

  private_class_method def self.complements
    COMPLEMENTS
  end
end

module BookKeeping
  # Where the version number matches the one in the test.
  VERSION = 4
end
